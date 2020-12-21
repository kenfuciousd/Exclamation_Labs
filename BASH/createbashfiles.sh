#!/usr/local/bin/bash

declare -a FILENAMES
declare -a FILEENTRIES

FILENAMES=("puppy.txt" "monkey.txt" "baby.txt")
FILEENTRIES=("Lassie" "George" "Maggie")

echo "Creating 3 Files"
for FN in ${FILENAMES[*]} 
do
	echo "we are adding" $FN
	touch $FN
	#Append the text entries into the files
	# one issue - this will continue appending FileEntries into the files each time.
	for FE in ${FILEENTRIES[*]} 
	do
		echo $FE >> $FN
	done
	echo "Viewing contents of" $FN ":"
	cat $FN
done
	
#check to see what was done.
LS -lisa

#object cleanup during testing
#for FN in ${FILENAMES[*]}
#do
#	echo "we are removing" $FN
#	rm $FN
#done

#check to see if the files were removed
#LS -lisa