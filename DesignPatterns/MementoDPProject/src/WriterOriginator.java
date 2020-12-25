//originator class
public class WriterOriginator {

    private StringBuilder information;

    public WriterOriginator() {

        //creates new StringBuilder
        //it is used to create modifiable string
        this.information = new StringBuilder();
    }

    public void write(String newInformation) {
        //appends strings to stringbuilder object
        information.append(newInformation);
    }

    //returns current state to caretaker as memento object
    //memento object is sent because if, originator object was sent, new modifications 
    //cannot be done without affecting previous states
    public WriterMemento save() {
        return new WriterMemento(this.information);
    }

    //gets previous memento instance from stack
    //access its information variable and set its value to current state information variable
    public void revertChange(WriterMemento wMemento) {
        WriterMemento writerMemento = wMemento;
        this.information = writerMemento.information;
    }

    @Override
	public String toString(){
		return this.information.toString();
	}

    static class WriterMemento {

        private StringBuilder information;

        public WriterMemento(StringBuilder information) {
            this.information = new StringBuilder(information);
        }
    
    }
    
}
