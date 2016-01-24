<?php
// bblog_migration.php
// Jon Sharp
// 7/8/2004

// To migrate data from my existing bblog blog to my new wordpress blog

$bblog_db = "bblog_db";
$bblog_category_table = "bB_sections";
$bblog_post_table = "bB_posts";
$bblog_comments_table = "bB_comments";

$wp_db = "wp_db";
$wp_category_table = "wp_categories";
$wp_post_table = "wp_posts";
$wp_comments_table = "wp_comments";

$dbhost = "localhost";
$dbuser = "user";
$dbpass = "pass";

if (!isset($argv[1])) {
	print "Usage: php bblog_migration.php <action>\n";
	print "	where <action> can be:\n";
	print "		categories - migrate categories\n";
	print "		posts - migrate posts\n";
	print "		comments - migrate comments\n";
	print "		do_post2cat - do special post2cat table conversion (debug)\n";
	print "		all - migrate all of the above\n";
	exit();
}

$db = mysql_connect($dbhost, $dbuser, $dbpass);

switch ($argv[1]) {

	case "all":
	case "categories":
		print "Migrating Categories...\n";
		// start with bblog db
		mysql_select_db($bblog_db);
		// transfer categories first
		$categories = array();
		$i = 0;
		$query = "select sectionid, nicename, name from $bblog_category_table";
		$result = mysql_query($query);
		while ($row = mysql_fetch_array($result)) {
			$categories[$i++] = $row;
		}

		mysql_select_db($wp_db);

		for ($i = 0; $i < count($categories); $i++) {
			$query = "insert into $wp_category_table (cat_ID, cat_name, category_nicename) values(".$categories[$i]['sectionid'].", \"".$categories[$i]['nicename']."\", \"".$categories[$i]['name']."\")";
//			print $query."\n";
			$result = mysql_query($query) or die("error inserting into $wp_category_table\n");
		}

		if ($argv[1] != all) { break; }

	case "posts":
		print "Migrating Posts...\n";
		// reselect bblog db
		mysql_select_db($bblog_db);

		// transfer posts next
		$posts = array();
		$i = 0;
		$query = "select postid, title, body, posttime, modifytime, status, modifier, sections, commentcount from $bblog_post_table";
		$result = mysql_query($query);
		while ($row = mysql_fetch_array($result)) {
			$posts[$i++] = $row;
		}

		// insert into wordpress db
		mysql_select_db($wp_db);

		// reduce sections string to single category
		for ($i = 0; $i < count($posts); $i++) {
			$sections = split(":", $posts[$i]['sections']);
			$posts[$i]['section'] = $sections[1];
		}

		// posts:
		for ($i = 0; $i < count($posts); $i++) {
			$query = "insert into $wp_post_table (ID, post_title, post_content, post_date, post_status, comment_status, ping_status, ".
					"post_name, post_category, post_modified, post_date_gmt, post_modified_gmt, post_author) ".
					"values(\"".$posts[$i]['postid']."\", \"".addslashes($posts[$i]['title'])."\", \"".addslashes($posts[$i]['body'])."\", ".
					"FROM_UNIXTIME('".$posts[$i]['posttime']."'), 'publish', 'open', 'open', \"".addslashes($posts[$i]['title'])."\", ".
					"".$posts[$i]['section'].", FROM_UNIXTIME('".$posts[$i]['modifytime']."'), ".
					"FROM_UNIXTIME('".($posts[$i]['posttime'] + 18000)."'), FROM_UNIXTIME('".($posts[$i]['modifytime'] + 18000)."'), ".
					"1 )";
//			print $query."\n";
			$result = mysql_query($query) or die("error inserting into $wp_post_table\n");
		}

		if ($argv[1] != all) { break; }

	case "do_post2cat":
		print "Linking Posts to Categories...\n";
		mysql_select_db($wp_db, $db);

		$query = "select ID, post_category from $wp_post_table";
//		print $query."\n";
		$result = mysql_query($query);
		while ($row = mysql_fetch_array($result)) {
			$insert = "insert into wp_post2cat (post_id, category_id) values(".$row["ID"].", ".$row["post_category"].")";
//			print $query;
			mysql_query($insert) or die("error inserting into wp_post2cat\n");
		}

		if ($argv[1] != all) { break; }

	case "comments":
		print "Migrating Comments...\n";
		// reselect bblog db
		mysql_select_db($bblog_db);
		// transfer comments next
		$comments = array();
		$i = 0;
		$query = "select commentid, parentid, postid, title, type, posttime, postername, posteremail, posterwebsite, posternotify, pubemail, pubwebsite, ip, commenttext, deleted from $bblog_comments_table";
		$result = mysql_query($query);
		while ($row = mysql_fetch_array($result)) {
			$comments[$i++] = $row;
		}

		// insert into wordpress db
		mysql_select_db($wp_db);

		// comments:
		for ($i = 0; $i < count($comments); $i++) {
			$query = "insert into $wp_comments_table (comment_post_ID, ".
					"comment_author, comment_author_email, comment_author_url, ".
					"comment_author_ip, comment_date, comment_date_gmt, ".
					"comment_content) ".
					"values(\"".$comments[$i]['postid']."\", \"".
					addslashes($comments[$i]['postername'])."\", \"".
					addslashes($comments[$i]['posteremail'])."\", \"".
					addslashes($comments[$i]['posterwebsite'])."\", \"".
					addslashes($comments[$i]['ip'])."\", ".
					"FROM_UNIXTIME('".$comments[$i]['posttime']."'), ".
					"FROM_UNIXTIME('".($comments[$i]['posttime'] + 18000)."'), \"".
					addslashes($comments[$i]['commenttext'])."\" )";
//			print $query."\n";
			mysql_query($query) or die("error inserting into $wp_comments_table\n");
		}

		if ($argv[1] != all) { break; }

		break;

	case "debug":
		print_r($categories);
		print_r($posts);
		print_r($comments);
		if ($argv[1] != all) { break; }
	
} // end switch

?>

