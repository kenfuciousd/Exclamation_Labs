# createThreeFiles.ps1 is a quick script to fulfill a technical requirements test
# Author Jason Dyer
#  dec 21 2020
#  for Exclamation Labs technical requirements test. 

$filenames = 'puppy.txt', 'monkey.txt', 'baby.txt'
$filecontent = 'Lassie', 'George', 'Maggie'

#for each file, and each line of content, create file and add content 
foreach ($file in $filenames) { 
	New-Item "./$file" -ItemType File 
	foreach ($content in $filecontent) { 
		Add-Content "./$file" $content	
	}  
}  

#now, read the files, print their contents
foreach ($file in $filenames){
	REM "Retrieving the content of" $file
	Get-Content $file
}
