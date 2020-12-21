
$filenames = 'puppy.txt', 'monkey.txt', 'baby.txt'
$filecontent = 'Lassie', 'George', 'Maggie'

foreach ($file in $filenames) { 
	New-Item "./$file" -ItemType File 
	foreach ($content in $filecontent) { 
		Add-Content "./$file" $content	
	}  

}  