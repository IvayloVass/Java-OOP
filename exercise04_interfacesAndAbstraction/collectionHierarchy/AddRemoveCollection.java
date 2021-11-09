package exercise04_interfacesAndAbstraction.collectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public String remove() {
        int lastItem = super.getItems().size() - 1;
        return super.getItems().remove(lastItem);
    }

    @Override
    public int add(String item) {
        super.getItems().add(0, item);
        return 0;
    }
}
