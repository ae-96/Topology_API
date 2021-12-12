# Topology_API
## Project requirements was: 
 Functional Requirements
Provide the functionality to:
1. Read a topology from a given JSON file and store it in the memory.
2. Write a given topology from the memory to a JSON file.
3. Query about which topologies are currently in the memory.
4. Delete a given topology from memory.
5. Query about which devices are in a given topology.
6. Query about which devices are connected to a given netlist node inba given topology.

 Non-Functional Requirements
1. Implementation must be done in an object-oriented manner
2. Choose a suitable programming language (other than Python) and justify your choice.
3. Use managed pointers (depends on programming language).
4. Using a managed build tool is a bonus (Gradle, Maven, ..).
5. Documentation on API level is a must.
6. Documentation on class level is a bonus.
7. Automatic testing on API level is a must.
8. Automatic testing on class level is a bonus.
9. Check your code with a code analysis tool of your choice.
10. Implement the requirements exactly, more is as bad as less.
11. Use version control to publish your code.
12. Make any other design choices as you see fit to the requirements and write them in your solution.

## Design solution
--> All function requirements acheieved and tested as illustrated in test.java 

--> Implementation is done in an object-oriented manner : 
      the project consist of 3 classes :
        - Topologylist : to store all topologies and provide the interface to the required APIs
        - Topology :  represent any topology and each  topology must has an ID and a list of components
        - Component : represents any component as JSONObject and can be easily modified to get anyinformation about any type of component
        
--> Java is used because in java it is so easy to deal with JSON files and is very helpful to implement in an object-oriented manner

--> Java Uses managed pointers by default by an abstracted way.

--> Documentation is done on BOTH API level and class level using javadoc comments inside the code

--> Automatic testing in this project with this design was meaningless and replaced by test.java

--> Code is checked with checkstyle tool and the code is clean as possible
