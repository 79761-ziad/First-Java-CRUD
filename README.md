# First Java CRUD – Task Manager

A simple console-based CRUD (Create, Read, Update, Delete) application written in plain Java.
No frameworks, no Maven, no external dependencies — just `javac` and `java`.

This project was created as part of the **First Java CRUD – 15.10** assignment, which focuses on
practising Git, GitHub, branches, Pull Requests, and pair collaboration.

---

## Features

- **Create** a task with a title and status (`TODO` / `DOING` / `DONE`)
- **Read** the list of all tasks
- **Update** a task's title and/or status
- **Delete** a task (with confirmation)
- In-memory storage (data is lost when the program exits)
- Simple numbered menu loop

---

## Requirements

- **Java JDK 17 or newer** (the code uses modern `switch` expressions with `->`)
- A terminal / command prompt

Check your version:

```bash
java -version
javac -version