public class Application {
    public static void main(String[] args) {

        WriterCaretaker writerCaretaker = new WriterCaretaker();
		WriterOriginator writerOriginator = new WriterOriginator();

        //appends to StringBuilder variable
        writerOriginator.write("Line One\n");
        System.out.println(writerOriginator);
        //saves state as memento object
        writerCaretaker.save(writerOriginator);

        //appends to StringBuilder variable
        writerOriginator.write("Line Two\n");
        System.out.println(writerOriginator);
        //saves state as memento object
        writerCaretaker.save(writerOriginator);

        //appends to StringBuilder variable
        writerOriginator.write("Line Three\n");
		System.out.println(writerOriginator);

        //reverts to previous state
        writerCaretaker.revert(writerOriginator);
        System.out.println(writerOriginator);

        //reverts to previous state
        writerCaretaker.revert(writerOriginator);
        System.out.println(writerOriginator);

    }
}
