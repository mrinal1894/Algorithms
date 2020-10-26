Using Manacher's algorithm to find the longest palindromic substring in a given string.

Firstly-> The String is modified such that # character is inserted in middle of all characters and the ends of the given string.
	  This is done basically to handle even as well as odd length palindromes.

Secondly-> Then the actual Manachers algorithm is used to find the longest palindromic subsequence in the modified string.
	   Manacher's algorithm takes linear time, in other words it's time complexity is O(n).

Lastly-> The result is printed out but before that, the '#' characters are removed. For string including '#', some other character can be used to 
         prevent wrong output.