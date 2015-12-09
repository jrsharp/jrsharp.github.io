;*************************************
;*           CommBoy                 *
;* an RS232 Terminal Program for GBC *
;*   for use with Ken Kaarvik's      *
;*      serial port circuit          *
;*                                   * 
;*    Jon Sharp        11/23/00      *
;*                                   * 
;*  Original code (and most          *
;*         substantial portion)      *
;*   written by Ken Kaarvik          *
;*************************************

blank	equ	16

        SECTION "Org $0",HOME
        ret

; Button Push Interrupt - For sending out data while
;                         waiting for input

	SECTION "Org $60",HOME[$60]
	push    af
	call	pad_Read
	call	send_test
	xor	a
	ldh	[$00],a
	pop	af
	reti


	INCLUDE	"HARDWARE.INC"
	INCLUDE	"IBMPC1.INC"
	INCLUDE	"ADDSUB1.INC"

	SECTION "Header",HOME[$0100]

	nop
	jp	Startup

	DB	$CE,$ED,$66,$66,$CC,$0D,$00,$0B,$03,$73,$00,$83,$00,$0C,$00,$0D
	DB	$00,$08,$11,$1F,$88,$89,$00,$0E,$DC,$CC,$6E,$E6,$DD,$DD,$D9,$99
	DB	$BB,$BB,$67,$63,$6E,$0E,$EC,$CC,$DD,$DC,$99,$9F,$BB,$B9,$33,$3E

		;0123456789ABCDE
	DB	"CommBoy        "
	DB	$80	;$80=Color GB
	DB	0,0,0	;SuperGameboy
	DB	0	;CARTTYPE
			;--------
			;0 - ROM ONLY
			;1 - ROM+MBC1
			;2 - ROM+MBC1+RAM
			;3 - ROM+MBC1+RAM+BATTERY
			;5 - ROM+MBC2
			;6 - ROM+MBC2+BATTERY

	DB	0	;ROMSIZE
			;-------
			;0 - 256 kBit ( 32 kByte,  2 banks)
			;1 - 512 kBit ( 64 kByte,  4 banks)
			;2 -   1 MBit (128 kByte,  8 banks)
			;3 -   2 MBit (256 kByte, 16 banks)
			;3 -   4 MBit (512 kByte, 32 banks)

	DB	0	;RAMSIZE
			;-------
			;0 - NONE
			;1 -  16 kBit ( 2 kByte, 1 bank )
			;2 -  64 kBit ( 8 kByte, 1 bank )
			;3 - 256 kBit (32 kByte, 4 banks)

	DW	$0000	;Manufacturer

	DB	0	;Version
	DB	0	;Complement check
	DW	0	;Checksum

	INCLUDE	"MEMORY1.ASM"
	INCLUDE	"KEYPAD.ASM"

	SECTION	"Main",home[$0150]

Startup
	call	initialize
Main

	call	inc_counter
	
	call	read_rs232

	call	wait_vb

	call	write_to_screen

	jp	Main

	ret

send_test
	ld	a,[_PadDataEdge]	;_PadData]

	cp	0
	ret	z

	cp	PADF_A
	jp	z,service_button_a
	cp	PADF_B
	jp	z,service_button_b
	cp	PADF_START
	jp	z,service_start
	cp	PADF_SELECT
	jp	z,service_select
	cp	PADF_UP
	jp	z,service_up
	cp	PADF_DOWN
	jp	z,service_down
	cp	PADF_LEFT
	jp	z,service_left
	cp	PADF_RIGHT
	jp	z,service_right
	ret

service_button_a
	ld	a,[inputchar]
	inc	a
	ld	[inputchar],a
	call	print_inputchar
	ret
service_button_b
	ld	a,[inputchar]
	dec	a
	ld	[inputchar],a
	call	print_inputchar
	ret
service_start
	ld	a,[inputchar]
	ld	b,a
	call	send_rs232
	ret
service_select
	ld	a,$FF
	ld	b,a
	call	send_rs232
	ret
service_up		;use joypad to scroll around screen - JS
	ld	a,[rSCY]
	sub	32
	ld	[rSCY],a
	ret
service_down
	ld	a,[rSCY]
	add	32
	ld	[rSCY],a
	ret
service_left
	ld	a,[rSCX]
	sub	32
	ld	[rSCX],a
	ret
service_right
	ld	a,[rSCX]
	add	32
	ld	[rSCX],a
	ret

clear_ram
	ld	a,blank
	ld	hl,raw_data
	ld	bc,36
	call	mem_Set
	ret

read_rs232		;read in byte at pin4
	ld	b,$80	;$01

	ei
	
wait_for_start_bit
	ldh	a,[$56]
	bit	4,a
	jp	nz,wait_for_start_bit
	di

	call	delay_130us

read_next_bit
	ldh	a,[$56]
	swap	a
	rr	a	;put pin 4 into carry
	rr	b
	
	jp	c,wait_for_stop_bit

	call	delay_104us

	jp	read_next_bit

wait_for_stop_bit

	call	delay_104us
	call	delay_104us

wait_for_after_stop_bit	

	ld	a,b
	ld	[raw_data],a
	ret

send_rs232			;send byte in B out Sout
	ld	e,8
	ld	a,0		;send start bit
	ldh	[$01],a
	ld	a,$83
	ldh	[$02],a
	call	delay_104us_send

send_next_bit
	rr	b
	ld	a,0
	jp	nc,keep_it_zero
	ld	a,$FF
keep_it_zero
	ldh	[$01],a
	ld	a,$83
	ldh	[$02],a
	call	delay_104us_send
	dec	e
	jp	nz,send_next_bit

	ld	a,$FF		;send stop bit
	ldh	[$01],a
	ld	a,$83
	ldh	[$02],a
	call	delay_104us_send

	ret

delay_130us
	ld	d,23
d130
	dec	d
	jp	nz,d130
	ret

delay_104us
	ld	d,17
d104
	dec	d
	jp	nz,d104
	ret

delay_104us_send
	ld	d,16
d104s
	dec	d
	jp	nz,d104s
	ret

inc_counter
	ld	a,[counter]
	inc	a
	ld	[counter],a
	ret

inc_charcounter
	ld	a,[charcounter]
	inc	a
	ld	[charcounter],a
	ret

write_to_screen

	call	inc_charcounter

	call	print_inputchar

	call	shift_curs_right
	
	call	wrap_text_to_nextline

	ld	a,[raw_data]
	call	display_char
	
	ret

shift_curs_right		;print incoming text to the right - JS
	
	ld	a,[hladdr]
	ld	h,a
	ld	a,[hladdr+1]
	ld	l,a
	inc	hl
	ld	a,h
	ld	[hladdr],a
	ld	a,l
	ld	[hladdr+1],a

	ret

wrap_text_to_nextline
	ld	a,[charcounter]
	cp	22
	jp	z,.next
	cp	42
	jp	z,.next
	cp	62
	jp	z,.next
	cp	82
	jp	z,.next
	cp	102
	jp	z,.next
	cp	122
	jp	z,.next
	cp	142
	jp	z,.next
	cp	162
	jp	z,.next
	cp	182
	jp	z,.next
	cp	202
	jp	z,.next
	cp	222
	jp	z,.next
	cp	242
	jp	z,.first
	ret
.first
	xor	a
	ld	[charcounter],a
	ld	hl,$9800+(32*2)
	ld	a,h
	ld	[hladdr],a
	ld	a,l
	ld	[hladdr+1],a
	ret
.next
	add16i	hl,12
	ld	a,h
	ld	[hladdr],a
	ld	a,l
	ld	[hladdr+1],a
	ret

print_inputchar
	lcd_WaitVRAM
	ld	a,[inputchar]
;	add	20
	ld	de,$9800+(32*18)+10
	ld	[de],a
	ret

display_byte			;enter with value in [de]
	lcd_WaitVRAM
	ld	a,[de]
	ld	b,a
	and	$F0
	swap	a
	ld	[hl+],a
	lcd_WaitVRAM
	ld	a,b
	and	$0F
	ld	[hl],a
	ret

display_char
	bit	7,a	;don't look up non print chars
	ret	nz

	push	af
	lcd_WaitVRAM
	pop	af
	ld	[hl],a
	ret

initialize
	di

.wait	ldh	a,[$44]		;LY LCDC compare
	cp	144
	jr	nc,.wait
	ld	a,0
	ldh	[$40],a		;LCDC lcd control

	ld	a,%10000000
	ldh	[$68],a		;BCPS
	ld	a,%00000000	;palette 0 0  bg
	ldh	[$69],a		;BCPD
	ld	a,%00000000
	ldh	[$69],a

	ld	a,%11111110	;palette 0 1
	ldh	[$69],a
	ld	a,%00011110
	ldh	[$69],a

	ld	a,%11111111	;palette 0 2  fg test font
	ldh	[$69],a
	ld	a,%01111111
	ldh	[$69],a

	ld	a,%11111111	;palette 0 3  fg ibm font
	ldh	[$69],a
	ld	a,%01111111
	ldh	[$69],a

	ld	hl,ibm_characters	;load ibm font
	ld	de,$8000		
	ld	bc,8*128
	call	mem_CopyMono


	ld	a,$FF		;blank char
	ld	hl,$9800
	ld	bc,20*32*32
	call	mem_Set

	ld	a,0
	ldh	[$42],a		;SCY Scroll Y
	ldh	[$43],a		;SCX Scroll X

	ld	a,%00000011
	ldh	[$47],a		;BGP

	ld	a,$00000000
	ldh	[$FF],a		;IE

	ld	a,%10010001
	ldh	[$40],a

	xor	a
	ld	[$FF24],a

	xor	a
	ld	[counter],a

	xor	a
	ld	[charcounter],a

	ld	a,%11000000
	ldh	[$56],a

	ld	a,$FF		;send stop bit
	ldh	[$01],a
	ld	a,$83
	ldh	[$02],a

	ld	a,IEF_HILO
	ldh	[rIE],a

	ld	a,$98		;fill hladdr - JS
	ld	[hladdr],a
	ld	a,$3D
	ld	[hladdr+1],a

	ld	a,$40		;init inputchar - JS
	ld	[inputchar],a
	
	ret

wait_vb
	ldh	a,[$44]
	cp	144
	jp	nz,wait_vb
	ret

ibm_characters
	chr_IBMPC1	1,8

	SECTION	"GB_ram",BSS
counter	DS	1
raw_data	DS	1
inputchar	DS	1	;added for keypad input handling - JS
charcounter	DS	1	;added to wrap lines around - JS
hladdr	DS	2	;added for output scrolling - JS

