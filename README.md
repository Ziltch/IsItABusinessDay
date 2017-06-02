# IsItABusinessDayInNorway
a check for whether a day(today) is a business day in Norway
It should be able to take any day as input as of now, but not everything has yet been tested well enough as of yet.

In case one has a setting where Saturday is off each week, one can add Calendar.SATURDAY to 
an ArrayList of Integers and send that in with the request.
If there are more days, one can add them as well. If no days, just send in an empty Collections list
(Only works by days of week for now)


TODO:
Make Tests for 2016, 2018, and a random year to check that everything works every year
Make Test for an entire leapyear.
