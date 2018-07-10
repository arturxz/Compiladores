SableCC Language to Compilers discipline

As it is, you need just to:
1: Clone the repositor. 
	
	git clone https://github.com/arturxz/compiladores

2: Import the directory you clone from github to yout Eclipse
	
	a) Right-click on a blank space in your eclipse's Package Explorer
	b) Select Import>General>Existing Project into a Workspace and select the dir

3: Add your SableCC jar to the classpath of the Workspace you just imported to Eclipse
	
	a) Right-click the Workspace, select Properties, Java Build Path
	b) On the Libraries tab, delete the existing sablecc reference with error and add yours
	
4: Make your life easier automating the SableCC

	a) Get in this site: http://web.archive.org/web/20090318023544/http://www.comp.nus.edu.sg/~sethhetu/rooms/Tutorials/EclipseAndSableCC.html
	
	b) Follow the "Creating a SableCC Tool" Section to automate the SableCC compilation Process.
	
	This site have a test on the SableCC. If you do not know how to prototype a language in SableCC, follow all the steps is recommended.