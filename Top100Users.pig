UserData=LOAD 'Projects/Usersoutput.txt' using PigStorage(';') as 
(reputation:long,display_name:chararray,views:long,upvote:long,downvote:long);
b=foreach UserData GENERATE *,0.2*(upvotes-downvotes)+0.3*views+0.5*reputation as value:int;
topusers=ORDER b BY value DESC;
topusers100=LIMIT topusers 100;

DUMP topusers100;
