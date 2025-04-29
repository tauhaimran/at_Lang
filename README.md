
# @Lang 
_Compiler Construction - Assignment#1_
Tauha Imran 22i-1239
Husain Ali 22i-0902

## Overview

This repository contains the solution to the **CS4031 - Compiler Construction** course assignment for **Spring 2025**. The objective of this assignment was to design and implement various components of a custom programming language compiler. The project includes several key elements such as:

- **Regular Expressions (RE), Non-deterministic Finite Automaton (NFA), Deterministic Finite Automaton (DFA)**
- **Lexical Analyzer** for tokenizing the input source code.
- **Symbol Table** for managing variables, functions, and constants.
- **Error Handler** to detect rule violations.
- **Transition State Table** for better clarity in parsing and state transitions.

This project demonstrates an understanding of the theory and practical application of compiler construction.

---

## Assignment Requirements

### 1. **Regular Expression (RE), NFA, and DFA**

Before implementing the lexical analyzer, we developed a workflow for the **NFA** and **DFA** based on regular expressions. The program can:

- **Create NFA** from regular expressions.
- **Convert NFA to DFA** using subset construction.
- Display the **total number of states** and a **transition state table** for each automaton.

### 2. **Lexical Analyzer**

The lexical analyzer reads the source code and breaks it into meaningful tokens. The analyzer is capable of:

- Recognizing and counting **different types of tokens**.
- Handling **pre-processing** for case sensitivity and whitespace.
- Managing **multiline comments** and **single-line comments**.
- Ensuring **arithmetic operations** and **variables** are properly tokenized.

### 3. **Symbol Table**

The **symbol table** is responsible for managing the program's identifiers. It handles:

- **Datatypes**: Boolean, Integer, Decimal, and Character.
- **Input/Output operations**.
- **Constants**: Both local and global constants.
- **Arithmetic operations**: Addition, Subtraction, Multiplication, Division, and Modulus.
- Proper handling of **scope management** for variables.
  
The symbol table supports operations related to **variable declarations**, **constants**, **data types**, and ensures the integrity of **arithmetic operations** in the language.

### 4. **Error Handler**

The **Error Handler** identifies and reports violations of syntax rules, including:

- **Invalid syntax** for arithmetic operations.
- **Undeclared variables**.
- **Mismatched data types**.
- **Misuse of constants or variables**.
- Errors are flagged with the **line number** and **error description** for clarity.

### 5. **Additional Features**

- **Transition State Table**: This table visually represents the state transitions for each token parsing step, making it easier to debug and understand the parsing process.
- **Support for Multiline Comments**: Proper handling of comments across multiple lines without causing errors in tokenization.
- **Case Sensitivity**: The lexical analyzer distinguishes between uppercase and lowercase identifiers.
  
---

## Features & Usage

### 1. **Workflow for NFA, DFA, and Regular Expressions**

- The program first accepts a **regular expression** as input.
- It then constructs the **NFA** and displays a **transition table**.
- Using **subset construction**, the NFA is converted into a **DFA**.
- The total number of states and transition tables for both NFA and DFA are shown in the console.

#### Example (NFA to DFA):

```java
// Example of a Regular Expression for a simple language
String regex = "(a|b)*abb";
NFA nfa = new NFA(regex);
DFA dfa = nfa.toDFA();
dfa.displayTransitionTable();
```

### 2. **Lexical Analyzer**

The lexical analyzer tokenizes the source code, handling:

- **Keywords** (e.g., `if`, `else`, `while`).
- **Identifiers** (variable names, function names).
- **Operators** (`+`, `-`, `*`, `/`, `%`).
- **Literals** (integers, decimals, booleans, characters).
- **Comments** (single-line and multi-line).
- **Whitespace** is ignored.

#### Example (Tokenization):

```java
// Example source code
String sourceCode = "int x = 5 + 3; // Addition";
LexicalAnalyzer lexer = new LexicalAnalyzer(sourceCode);
lexer.tokenize();
```

### 3. **Symbol Table**

The symbol table manages variables, constants, and their scope:

- Tracks **local** and **global variables**.
- Handles **constant values**.
- Validates **data types** for correct assignments.

#### Example (Symbol Table):

```java
// Example of variable declaration and assignment
SymbolTable symbolTable = new SymbolTable();
symbolTable.addVariable("x", "Integer", 5);
symbolTable.addConstant("PI", "Decimal", 3.14159);
```

### 4. **Error Handling**

The error handler identifies and reports errors:

- **Uninitialized variables**.
- **Invalid arithmetic operations**.
- **Mismatched types** during assignments.
  
#### Example (Error Handling):

```java
// Example source code with an error
String sourceCodeWithError = "int x = 5 + true;";
ErrorHandler errorHandler = new ErrorHandler();
errorHandler.checkForErrors(sourceCodeWithError);
```

---

## Constraints & Requirements

- **Data Types Supported**: Boolean, Integer, Decimal, Character.
- **Valid Identifiers**: Only lowercase letters (`a` to `z`) are valid variable names.
- **Arithmetic Operations Supported**: Addition (`+`), Subtraction (`-`), Multiplication (`*`), Division (`/`), Modulus (`%`).
- **Decimal Precision**: Decimal numbers are rounded to five decimal places.
- **Exponentiation Support**: Support for raising numbers to a power (e.g., `5^3`).

### Supported File Types

- Custom source code files with the `.mylang` extension.

---

## How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/tauhaimran/at_Lang.git
   ```

2. **Build the Project**:
   Use Maven to build the project:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   After building, run the application using the following command:
   ```bash
   mvn exec:java
   ```

   The application will display the transition state tables, tokenized output, and any errors found in the source code.

---

## Contribution Guidelines

- Fork the repository and create a new branch.
- Implement your features or fix bugs in separate branches.
- Push your changes and create a pull request for review.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Conclusion

This project is a comprehensive solution for the **CS4031 Compiler Construction** assignment. It covers multiple phases of a compiler including **lexical analysis**, **syntax analysis**, and **error handling**, while adhering to the constraints provided in the assignment. It demonstrates core concepts in compiler construction and is designed to be easily extensible for future assignments.

---

Let me know if you need further adjustments or additions!Sure! Here's a **detailed README** for your repository, focusing on the **assignment solution** for **CS4031-Compiler Construction** at the **National University of Computer and Emerging Sciences (FAST)**. This is designed to be clear, informative, and meets the assignment's specific requirements:

---

# @Lang Compiler Construction - Assignment 01

## Overview

This repository contains the solution to the **CS4031 - Compiler Construction** course assignment for **Spring 2025**. The objective of this assignment was to design and implement various components of a custom programming language compiler. The project includes several key elements such as:

- **Regular Expressions (RE), Non-deterministic Finite Automaton (NFA), Deterministic Finite Automaton (DFA)**
- **Lexical Analyzer** for tokenizing the input source code.
- **Symbol Table** for managing variables, functions, and constants.
- **Error Handler** to detect rule violations.
- **Transition State Table** for better clarity in parsing and state transitions.

This project demonstrates an understanding of the theory and practical application of compiler construction.

---

## Assignment Requirements

### 1. **Regular Expression (RE), NFA, and DFA**

Before implementing the lexical analyzer, we developed a workflow for the **NFA** and **DFA** based on regular expressions. The program can:

- **Create NFA** from regular expressions.
- **Convert NFA to DFA** using subset construction.
- Display the **total number of states** and a **transition state table** for each automaton.

### 2. **Lexical Analyzer**

The lexical analyzer reads the source code and breaks it into meaningful tokens. The analyzer is capable of:

- Recognizing and counting **different types of tokens**.
- Handling **pre-processing** for case sensitivity and whitespace.
- Managing **multiline comments** and **single-line comments**.
- Ensuring **arithmetic operations** and **variables** are properly tokenized.

### 3. **Symbol Table**

The **symbol table** is responsible for managing the program's identifiers. It handles:

- **Datatypes**: Boolean, Integer, Decimal, and Character.
- **Input/Output operations**.
- **Constants**: Both local and global constants.
- **Arithmetic operations**: Addition, Subtraction, Multiplication, Division, and Modulus.
- Proper handling of **scope management** for variables.
  
The symbol table supports operations related to **variable declarations**, **constants**, **data types**, and ensures the integrity of **arithmetic operations** in the language.

### 4. **Error Handler**

The **Error Handler** identifies and reports violations of syntax rules, including:

- **Invalid syntax** for arithmetic operations.
- **Undeclared variables**.
- **Mismatched data types**.
- **Misuse of constants or variables**.
- Errors are flagged with the **line number** and **error description** for clarity.

### 5. **Additional Features**

- **Transition State Table**: This table visually represents the state transitions for each token parsing step, making it easier to debug and understand the parsing process.
- **Support for Multiline Comments**: Proper handling of comments across multiple lines without causing errors in tokenization.
- **Case Sensitivity**: The lexical analyzer distinguishes between uppercase and lowercase identifiers.
  
---

## Features & Usage

### 1. **Workflow for NFA, DFA, and Regular Expressions**

- The program first accepts a **regular expression** as input.
- It then constructs the **NFA** and displays a **transition table**.
- Using **subset construction**, the NFA is converted into a **DFA**.
- The total number of states and transition tables for both NFA and DFA are shown in the console.

#### Example (NFA to DFA):

```java
// Example of a Regular Expression for a simple language
String regex = "(a|b)*abb";
NFA nfa = new NFA(regex);
DFA dfa = nfa.toDFA();
dfa.displayTransitionTable();
```

### 2. **Lexical Analyzer**

The lexical analyzer tokenizes the source code, handling:

- **Keywords** (e.g., `if`, `else`, `while`).
- **Identifiers** (variable names, function names).
- **Operators** (`+`, `-`, `*`, `/`, `%`).
- **Literals** (integers, decimals, booleans, characters).
- **Comments** (single-line and multi-line).
- **Whitespace** is ignored.

#### Example (Tokenization):

```java
// Example source code
String sourceCode = "int x = 5 + 3; // Addition";
LexicalAnalyzer lexer = new LexicalAnalyzer(sourceCode);
lexer.tokenize();
```

### 3. **Symbol Table**

The symbol table manages variables, constants, and their scope:

- Tracks **local** and **global variables**.
- Handles **constant values**.
- Validates **data types** for correct assignments.

#### Example (Symbol Table):

```java
// Example of variable declaration and assignment
SymbolTable symbolTable = new SymbolTable();
symbolTable.addVariable("x", "Integer", 5);
symbolTable.addConstant("PI", "Decimal", 3.14159);
```

### 4. **Error Handling**

The error handler identifies and reports errors:

- **Uninitialized variables**.
- **Invalid arithmetic operations**.
- **Mismatched types** during assignments.
  
#### Example (Error Handling):

```java
// Example source code with an error
String sourceCodeWithError = "int x = 5 + true;";
ErrorHandler errorHandler = new ErrorHandler();
errorHandler.checkForErrors(sourceCodeWithError);
```

---

## Constraints & Requirements

- **Data Types Supported**: Boolean, Integer, Decimal, Character.
- **Valid Identifiers**: Only lowercase letters (`a` to `z`) are valid variable names.
- **Arithmetic Operations Supported**: Addition (`+`), Subtraction (`-`), Multiplication (`*`), Division (`/`), Modulus (`%`).
- **Decimal Precision**: Decimal numbers are rounded to five decimal places.
- **Exponentiation Support**: Support for raising numbers to a power (e.g., `5^3`).

### Supported File Types

- Custom source code files with the `.mylang` extension.

---

## How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/tauhaimran/at_Lang.git
   ```

2. **Build the Project**:
   Use Maven to build the project:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   After building, run the application using the following command:
   ```bash
   mvn exec:java
   ```

   The application will display the transition state tables, tokenized output, and any errors found in the source code.

---

## Contribution Guidelines

- Fork the repository and create a new branch.
- Implement your features or fix bugs in separate branches.
- Push your changes and create a pull request for review.

---

## Conclusion

This project is a comprehensive solution for the **CS4031 Compiler Construction** assignment. It covers multiple phases of a compiler including **lexical analysis**, **syntax analysis**, and **error handling**, while adhering to the constraints provided in the assignment. It demonstrates core concepts in compiler construction and is designed to be easily extensible for future assignments.

---
