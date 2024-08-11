class MainCategoryNode{
    String code;
    int inStock;
    MainCategoryNode next;
    SubCategoryNode subHead;

    MainCategoryNode(String code, int inStock){
        this.code=code;
        this.inStock=inStock;
        this.next=null;
        this.subHead=null;
    }
}
class SubCategoryNode{
    String code;
    int inStock;
    SubCategoryNode next;
    SubSubCategoryNode subSubHead;

    SubCategoryNode(String code, int inStock){
        this.code=code;
        this.inStock=inStock;
        this.next=null;
        this.subSubHead=null;
    }
}
class SubSubCategoryNode{
    String code;
    int inStock;
    SubSubCategoryNode next;

    SubSubCategoryNode(String code, int inStock){
        this.code=code;
        this.inStock=inStock;
        this.next=null;
    }
}

class Inventory{
    MainCategoryNode first;

    public void insert(String code,int n){
        String mainCode=code.substring(0,2);
        String subCode=code.substring(2, 4);
        String subSubCode=code.substring(4, 6);

        MainCategoryNode mainCategory = findMainCategory(mainCode);
        if (mainCategory == null) {
            mainCategory = new MainCategoryNode(mainCode, 0);
            insertMainCategory(mainCategory);
        }
        mainCategory.inStock += n;

        SubCategoryNode subCategory = findSubCategory(mainCategory, subCode);
        if (subCategory == null) {
            subCategory = new SubCategoryNode(subCode, 0);
            insertSubCategory(mainCategory, subCategory);
        }
        subCategory.inStock += n;

        SubSubCategoryNode subSubCategory = findSubSubCategory(subCategory, subSubCode);
        if (subSubCategory == null) {
            subSubCategory = new SubSubCategoryNode(subSubCode, 0);
            insertSubSubCategory(subCategory, subSubCategory);
        }
        subSubCategory.inStock += n;

        cleanUpIfZeroStock(mainCategory, subCategory, subSubCategory);
    }

    public void merge(int n, int m) {
        MainCategoryNode nodeN = getNodeAt(n);
        MainCategoryNode nodeM = getNodeAt(m);

        if (nodeN == null || nodeM == null){
            return;
        }

        String codeN = nodeN.code;
        String codeM = nodeM.code;

        if (codeN.charAt(0) == codeM.charAt(0)) {
            String newCode = mergeCodes(codeN, codeM);
            nodeN.code = newCode;
            nodeN.inStock += nodeM.inStock;
            mergeSubCategories(nodeN, nodeM);
            deleteNode(nodeM);
        }
    }

    public void search(String code) {
        if (code.length() == 2) {
            MainCategoryNode mainCategory = findMainCategory(code);
            if (mainCategory != null) {
                System.out.println(mainCategory.inStock);
            }
        } else if (code.length() == 4) {
            MainCategoryNode mainCategory = findMainCategory(code.substring(0, 2));
            SubCategoryNode subCategory = findSubCategory(mainCategory, code.substring(2, 4));
            if (subCategory != null) {
                System.out.println(subCategory.inStock);
            }
        } else if (code.length() == 6) {
            MainCategoryNode mainCategory = findMainCategory(code.substring(0, 2));
            SubCategoryNode subCategory = findSubCategory(mainCategory, code.substring(2, 4));
            SubSubCategoryNode subSubCategory = findSubSubCategory(subCategory, code.substring(4, 6));
            if (subSubCategory != null) {
                System.out.println(subSubCategory.inStock);
            }
        }
    }

    public void printAll() {
        if (first == null){
             return;
        }

        MainCategoryNode mainPtr = first;
        do {
            SubCategoryNode subPtr = mainPtr.subHead;
            while (subPtr != null) {
                SubSubCategoryNode subSubPtr = subPtr.subSubHead;
                while (subSubPtr != null) {
                    System.out.println(mainPtr.code + subPtr.code + subSubPtr.code + " " + subSubPtr.inStock);
                    subSubPtr = subSubPtr.next;
                }
                subPtr = subPtr.next;
            }
            mainPtr = mainPtr.next;
        } while (mainPtr != first);
    }




    //-----------------------------------------------Helper Functions-----------------------------------------------
    private MainCategoryNode findMainCategory(String code) {
        if (first == null){
            return null;
        }

        MainCategoryNode save = first;
        do {
            if (save.code.equals(code)) {
                return save;
            }
            save = save.next;
        } while (save != first);
        return null;
    }

    private SubCategoryNode findSubCategory(MainCategoryNode main,String code) {
        if (main == null || main.subHead == null){
            return null;
        }

        SubCategoryNode save = main.subHead;
        while (save != null){
            if (save.code.equals(code)) {
                return save;
            }
            save = save.next;
        }
        return null;
    }

    private SubSubCategoryNode findSubSubCategory(SubCategoryNode sub,String code) {
        if (sub == null || sub.subSubHead == null){
            return null;
        }

        SubSubCategoryNode save = sub.subSubHead;
        while (save != null){
            if (save.code.equals(code)) {
                return save;
            }
            save = save.next;
        }
        return null;
    }


    //Inserting Node
    private void insertMainCategory(MainCategoryNode node) {
        if (first == null) {
            first = node;
            node.next = first;  // Circular link
        } else {

            MainCategoryNode temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = first;
        }
    }
    
    private void insertSubCategory(MainCategoryNode main, SubCategoryNode sub) {
        if (main.subHead == null) {
            main.subHead = sub;
        } else {
            SubCategoryNode temp = main.subHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = sub;
        }
    }
    
    private void insertSubSubCategory(SubCategoryNode sub, SubSubCategoryNode subSub) {
        if (sub.subSubHead == null) {
            sub.subSubHead = subSub;
        } else {
            SubSubCategoryNode temp = sub.subSubHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = subSub;
        }
    }
    
    //Clean Up
    private void cleanUpIfZeroStock(MainCategoryNode main, SubCategoryNode sub, SubSubCategoryNode subSub) {
        if (subSub.inStock <= 0) {
            if (sub.subSubHead == subSub) {
                sub.subSubHead = subSub.next;
            } else {
                SubSubCategoryNode prev = sub.subSubHead;
                while (prev.next != subSub) {
                    prev = prev.next;
                }
                prev.next = subSub.next;
            }
        }
        
        if (sub.inStock <= 0 && sub.subSubHead == null) {
            if (main.subHead == sub) {
                main.subHead = sub.next;
            } else {
                SubCategoryNode prev = main.subHead;
                while (prev.next != sub) {
                    prev = prev.next;
                }
                prev.next = sub.next;
            }
        }
        
        if (main.inStock <= 0 && main.subHead == null) {
            if (first == main) {
                if (first.next == first) {
                    first = null;  // List is empty now
                } else {
                    MainCategoryNode temp = first;
                    while (temp.next != first) {
                        temp = temp.next;
                    }
                    temp.next = first.next;
                    first = first.next;
                }
            } else {
                MainCategoryNode prev = first;
                while (prev.next != main) {
                    prev = prev.next;
                }
                prev.next = main.next;
            }
        }
    }

    //Merging two main Category Node
    private void mergeSubCategories(MainCategoryNode n, MainCategoryNode m) {
        SubCategoryNode subPtrM = m.subHead;
        while (subPtrM != null) {
            SubCategoryNode subPtrN = findSubCategory(n, subPtrM.code);
            if (subPtrN == null) {
                insertSubCategory(n, new SubCategoryNode(subPtrM.code, subPtrM.inStock));
                subPtrN = findSubCategory(n, subPtrM.code);
            } else {
                subPtrN.inStock += subPtrM.inStock;
            }
            SubSubCategoryNode subSubPtrM = subPtrM.subSubHead;
            while (subSubPtrM != null) {
                SubSubCategoryNode subSubPtrN = findSubSubCategory(subPtrN, subSubPtrM.code);
                if (subSubPtrN == null) {
                    insertSubSubCategory(subPtrN, new SubSubCategoryNode(subSubPtrM.code, subSubPtrM.inStock));
                } else {
                    subSubPtrN.inStock += subSubPtrM.inStock;
                }
                subSubPtrM = subSubPtrM.next;
            }
            subPtrM = subPtrM.next;
        }
    }
    
    private String mergeCodes(String code1, String code2) {
        char b = code1.charAt(1);
        char h = code2.charAt(1);
        return "0" + (b < h ? b + "" + h : h + "" + b);
    }
    
    //Delete Node
    private void deleteNode(MainCategoryNode node) {
        if (first == null || node == null){
             return;
        }
    
        if (first == node && first.next == first) {
            first = null; // Only one node in the list
            return;
        }
    
        MainCategoryNode prev = first;
        while (prev.next != node) {
            prev = prev.next;
        }
    
        if (node == first) {
            prev.next = first.next;
            first = first.next;
        } else {
            prev.next = node.next;
        }
    }

    //Node At Position
    private MainCategoryNode getNodeAt(int position) {
        if (first == null){
            return null;
        }

        MainCategoryNode current = first;
        int count = 1;
        do {
            if (count == position) {
                return current;
            }
            current = current.next;
            count++;
        } while (current != first);
        return null;
    }
    
}
public class DSMID004 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.insert("010203", 10);
        inventory.insert("010204", 5);
        inventory.insert("020203", 7);
        
        inventory.printAll(); // prints all sub-sub-categories with stock

        inventory.merge(2, 1); // merge first and second main category if possible

        System.out.println("Merge the MainCategory");
        inventory.printAll(); // prints all sub-sub-categories with updated stock
    }
}
