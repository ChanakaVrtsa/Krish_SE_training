import java.util.Stack;

//caretaker-holds state of objects
public class WriterCaretaker {

    //stores every memento instances in LIFO order
    Stack<WriterOriginator.WriterMemento> history = new Stack<>();
    
    //retrieves memento object and inserts into stack
	public void save(WriterOriginator writerOriginator) {
		history.push(writerOriginator.save());
	}
	
	public void revert(WriterOriginator writerOriginator) {
        //checks if stack is not empty
        if(!history.isEmpty()) {
            //passes memento object from stack to originator to revert changes
            writerOriginator.revertChange(history.pop());
        } else {
            System.out.println("Cannot revert");
        }
		
	}
    
}
