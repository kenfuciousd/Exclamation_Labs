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
sequence = 0
// let's build this into a function, whose input is the full identity
// .. plus the formatting type to return.
String makeUserName(ArrayList user, String format){
	//In [first, middle, last, nick]
	def output = ""
	def firstName = user[0]
	def middleName
	if(user[1]) {middleName = user[1]}
	def lastName = user[2]
	def nickName
	if(user[3]){nickName = user[3]}
	//now to format it:
//	print "parsed: -- $firstName + $middleName + $lastName + $nickName + $format + $sequence-- "
	switch(format){
	    case ~/(?i)A/:
	    	// <first_initial_of_first_name><lastname><numeric_sequence> 
//			print "Case A"
			output = firstName.substring(0,1) + lastName + sequence
			sequence++
			return output; //..(and that would be it? no need for break)
	    	break;
	    case ~/(?i)B/:
			//<first_name><nickname_if_present><lastname><numeric_sequence> 
//			print "Case B"
			if(nickName != null){ output = firstName + nickName + lastName + sequence}
			else{output = firstName + lastName + sequence}
			//sequence++
			return output;
	    	break;
	    case ~/(?i)C/:
	    	//<first_initial_of_nickname_if_present_otherwise_use_fi_of_firstname><lastname><numeric_sequence>
//			print "Case C"
			if(nickName != null){output = nickName.substring(0,1) + lastName + sequence}
			else{output = firstName.substring(0,1) + lastName + sequence}
			sequence++
			return output;
	    	break;
	    case ~/(?i)D/:
	    	//<Lastname><comma><Firstname><comma_if_middlename><Middlename><comma_if_nickname><Nickname><numeric_sequence> 
//			print "Case D"
			output = "$lastName,$firstName"
			if(middleName != null){ output += ",$middleName"}
			if(nickName != null){output += ",$nickName"}
			output += ","+sequence.toString()
			sequence++
			return output;
	    	break;
	    default: "This not a valid formatting type, choose A, B, C, or D\n"
	}// end switch format
//	return output;   // could probably just do this in the format case switch
}

//// A ////
// in the following format <first_initial_of_first_name><lastname><numeric_sequence> 
def formatA(List list) { 
	def usernames = []
	list.eachWithIndex{row, i ->
		def username = makeUserName(row, "A") // the new function

		usernames.add(username)
	}
	return usernames 
	} 
print "Format A: "+ formatA(identities) + "\n" 

// B 
// in the following format 
//<first_name><nickname_if_present><lastname><numeric_sequence> 
def formatB(List list) { 
	def usernames = []
	list.eachWithIndex{row, i ->
		def username = makeUserName(row, "B") // the new function
		usernames.add(username)
	}
	return usernames 
} 
print "Format B: " + formatB(identities) + "\n" 

// C 
// in the following format 
//<first_initial_of_nickname_if_present_otherwise_use_fi_of_firstname><lastname><numeric_sequence> 
def formatC(List list) { 
	def usernames = []
	list.eachWithIndex{row, i ->
		def username = makeUserName(row, "C") // the new function
		usernames.add(username)
	}
	return usernames 
} 
print "Format C: " + formatC(identities) + "\n" 

// D 
// in the following format 
//<Lastname><comma><Firstname><comma_if_middlename><Middlename><comma_if_nickname><Nickname><numeric_sequence> 
def formatD(List list) { 
	def usernames = []
	list.eachWithIndex{row, i ->
		def username = makeUserName(row, "D") // the new function
		usernames.add(username)
	}
	return usernames 
} 
print "Format D: " + formatD(identities) + "\n"