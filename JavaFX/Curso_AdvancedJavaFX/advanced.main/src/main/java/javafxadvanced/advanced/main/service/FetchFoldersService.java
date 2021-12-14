package javafxadvanced.advanced.main.service;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafxadvanced.advanced.main.model.EmailTreeItem;

public class FetchFoldersService extends Service<Void>{

    private Store store;
    private EmailTreeItem<String> foldersRoot;

    public FetchFoldersService(Store store, TreeItem<String> treeItem) {
        this.store = store;
        this.foldersRoot = (EmailTreeItem<String>) treeItem;
    }

    @Override
    protected Task<Void> createTask(){
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception{
                FetchFolders();
                return null;
            }
        };
    }

    protected void FetchFolders() throws MessagingException {
        Folder[] folders = store.getDefaultFolder().list();
        handleFolders(folders, foldersRoot);
    }   

    private void handleFolders(Folder[] folders, EmailTreeItem<String> foldersRoot){
        for(Folder folder: folders){
            EmailTreeItem<String> emailTreeItem = new EmailTreeItem<String>(folder.getName());
            foldersRoot.getChildren().add((emailTreeItem));
            foldersRoot.setExpanded(true);

            if(folder.getType() == folder.HOLDS_FOLDERS) {
                Folder[] subFolders = folder.list();
                handleFolders(subFolders, emailTreeItem);
            }
        }
    }
}