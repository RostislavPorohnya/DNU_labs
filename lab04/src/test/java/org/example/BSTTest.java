package org.example;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

public class BSTTest {
    Map<Integer,String> tree;

    @BeforeEach
    void treeInit() {
        tree = new HashMap<>();

        tree.put(11,"Одинадцять");
        tree.put(19,"Дев'ятнадцять");
        tree.put(15,"П'ятнадцять");
        tree.put(25,"Двадцять п'ять");
        tree.put(12,"Дванадцять");
        tree.put(13,"Тринадцять");
        tree.put(16,"Шістнадцять");
        tree.put(7,"Сім");
        tree.put(24,"Двадцять чотири");
        tree.put(20,"Двадцять");
        tree.put(10,"Десять");
        tree.put(21,"Двадцять один");
        tree.put(8,"Вісім");
        tree.put(17,"Сімнадцять");
        tree.put(18,"Вісімнадцять");
        tree.put(9,"Дев'ять");
        tree.put(26,"Двадцять шість");
        tree.put(23,"Двадцять три");
        tree.put(14,"Чотирнадцять");
        tree.put(22,"Двадцять два");
    }

    private BSTNode mapTransferBstnode() {
        BSTNode node = new BSTNode();

        for (Map.Entry<Integer,String> item: tree.entrySet()) {
            node.insertValue(item.getKey(), item.getValue());
        }
        return node;
    }

    @Test
    void Test1() {
        BSTNode node = mapTransferBstnode();

        Assertions.assertEquals(20,tree.size());
    }

    @Test
    void Test2() {
        BSTNode node = mapTransferBstnode();

        node.depthOrderTraversal();
        System.out.println();
        Assertions.assertEquals(20,tree.size());
    }

    @Test
    void Test3() {
        BSTNode node = mapTransferBstnode();

        Assertions.assertEquals("Двадцять один",node.searchValue(21));
        Assertions.assertNull(node.searchValue(90));
        Assertions.assertEquals("Дев'ятнадцять",node.searchValue(19));
        Assertions.assertNull(node.searchValue(45));
    }

    @Test
    void Test4() {
        BSTNode node = new BSTNode();

        for (Map.Entry<Integer,String> item: tree.entrySet()) {
            if(item.getKey()!=20) {
                node.insertValue(item.getKey(), item.getValue());
            }
        }


        node.insertValue(20,"Двадцять");

        System.out.println(node.searchValue(20));
        Assertions.assertEquals("Двадцять",node.searchValue(20));
        node.insertValue(20,"Інше двадцять");

        node.depthOrderTraversal();
        System.out.println();
        Assertions.assertEquals(20, node.getSize());

        System.out.println(node.searchValue(20));
        Assertions.assertEquals("Інше двадцять",node.searchValue(20));
    }
    @Test
    void Test5() {
        BSTNode node = mapTransferBstnode();

        node.deleteValue(14);

        node.depthOrderTraversal();
        System.out.println();
        Assertions.assertEquals(19, node.getSize());
        Assertions.assertNull(node.searchValue(14));
    }
}