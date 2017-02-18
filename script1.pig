UserData = LOAD 'users' using PigStorage() as (
	row_id:chararray,
	reputation:long,
	creation_date:chararray,
	display_name:chararray,
	lastaccess_date:chararray,
	website_url:chararray,
	location:chararray,
	views:long,
	upvote:long,
	downvote:long,
	account_id:long
);

TopUsersUpVotesAll = ORDER UserData BY upvote DESC;
TopUsersUpVotes100 = LIMIT TopUsersUpVotesAll 100;

value = FOREACH UserData GENERATE 0.2*(upvote-downvote)+0.3*views+0.5*reputation;

sorted_value = ORDER value by ASC;

Topsorted_value = 