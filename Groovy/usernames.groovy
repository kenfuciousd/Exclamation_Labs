// List of identities in CSV format 
// Firstname, Middlename, Lastname, Nickname 
def identities = [ 
["John", "Jacob", "Schmidt", "Jingleheimer"], 
["Billie", "", "Jean", ""], 
["ELEANOR", "", "RIGBY", ""], 
["Slim", "", "Shady", "Marshal"], 
["Eleanor", "", "Rigby", ""] 
] 
// Complete the functions by returning an array of usernames. Use sequences 
// to prevent duplicates, but only when a duplicate occurs. 
// A 
// in the following format <first_initial_of_first_name><lastname><numeric_sequence> 
def formatA(List list) { 
// beginning edits here
// loop through the list, get ahold of each entry, manipulate as needed.
// side note, is this formatting to keep whitespace down? need to research.
for(i in 0 .. list.size()-1) { 
	def entry = list[i].split{','}
	print "Split gave us: " + entry + "\n"
	for(j in 0 .. entry.size()-1){
		print "inside the for loop, at " + entry[j] + "\n"
	}
}	
def usernames = list 
return usernames 
} 
print formatA(identities) + "\n" 

// B 
// in the following format <first_name><nickname_if_present><lastname><numeric_sequence> 
def formatB(List list) { 
def usernames = list 
return usernames 
} 
print formatB(identities) + "\n" 

// C 
// in the following format <first_initial_of_nickname_if_present_otherwise_use_fi_of_firstname><lastnam e><numeric_sequence> 
def formatC(List list) { 
def usernames = list 
return usernames 
} 
print formatC(identities) + "\n" 

// D 
// in the following format <Lastname><comma><Firstname><comma_if_middlename><Middlename><comma_if_nickn ame><Nickname><numeric_sequence> 
def formatD(List list) { 
def usernames = list 
return usernames 
} 
print formatD(identities) + "\n"