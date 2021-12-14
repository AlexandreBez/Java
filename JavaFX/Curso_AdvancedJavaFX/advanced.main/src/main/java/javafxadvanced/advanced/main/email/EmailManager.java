package javafxadvanced.advanced.main.email;

import javafx.scene.control.TreeItem;
import javafxadvanced.advanced.main.model.EmailAccount;
import javafxadvanced.advanced.main.model.EmailTreeItem;
import javafxadvanced.advanced.main.service.FetchFoldersService;

public class EmailManager {
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public TreeItem<?> getFoldersRoot(){
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount){
        TreeItem<String> treeItem = new TreeItem<String>(emailAccount.getAddress());
        treeItem.setExpanded(true);
        FetchFoldersService fetchFoldersService = new FetchFoldersService(emailAccount.getStore(), treeItem);
        fetchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}