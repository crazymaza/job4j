package tracker;

public class ValidateMenuItems implements UserAction {
    private UserAction userAction;


    public ValidateMenuItems(UserAction userAction) {
        this.userAction = userAction;
    }

    @Override
    public int key() {
        return userAction.key();
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        boolean isTrue = true;
        do {
            try {
                this.userAction.execute(input, tracker);
                isTrue = false;
            } catch (NullPointerException e) {
                System.out.println("Item not found.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of array range.");
            } catch (NumberFormatException e) {
                System.out.println("Only numbers please.");
            } catch (MenuOutException e) {
                System.out.println("Id less then zero!");
            } catch (IdNotFoundException e) {
                System.out.println("Id not found.");
            }
        } while (isTrue);
    }

    @Override
    public String info() {
        return userAction.info();
    }
}
