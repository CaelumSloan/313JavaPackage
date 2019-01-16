Lecture 1 had so many definitions of 'things' in this theory I felt the concepts were better shown using class definitions and constructors.
Here ya'll are. Hopefully it proves helpful in understanding Automata Theory.

# Installation
You should just be able to move the threeThirteen folder into your java project along with your other packages, and say
using threeThirteen;
to gain access to all the 313 objects
Additionally, you can try importing using the jar in releases.

# Notes
using threeThirteen; overides String! if you want your usual strings pack either say threeThirteen.String everytime you use a 313 or say using threeThirteen; and say java.lang.String everytime you use a String. Note that method1("just make a string with quotes") still works fine.

I used the javatuples library under the permissive free software license for this so Pair documentation is there. Also thanks for the library it worked awesome!
https://www.javatuples.org/index.html

# Problems with using java to represent theory
At the present time strings are not explicitly nor exclusively linked to any alphabet.
However, Ben MacAdam's seems to imply alphabets are needed to define a String.
This is likely a mistake on my part but I'm inclined to keep it around at the very least for convenience, until I find something more decisive as to whether it is necessary to be one way or another.

This java environment cannot replicate many aspects of the 313 theory.
One important example is that a string is a sequence of symbols **from a alphabet**.
Here the *existence* of such alphabet is not hard to provide - it is merely any alphabet that includes all the symbols involved in the string.
However, in java we do not have any enormous pile of alphabets laying around - it must be manually created to similarly 'exist'.
Despite this, the code is used as if the existence of any one of these objects is obvious, and 'creating an object' is merely defining which object in specific you are talking about.
This is why all the objects so far (1.0) are immutable.

That basically boils down to the inability to represent 'for all'. Similarly I can not represent the set of strings over an alphabet or other infinite concepts.
