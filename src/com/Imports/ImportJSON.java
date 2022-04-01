package com.Imports;

import com.Items.Armor;
import com.Items.Item;
import com.Items.Weapons;
import com.Players.Player;
import com.Rooms.Room;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ImportJSON {

    public static Collection<Item> getItems() throws IOException, ParseException {
        Object objItems = new JSONParser().parse(new FileReader("src/com/JsonObjects/items.json"));
        Collection<Object> inventory = new ArrayList<>();
        Collection<Item> items = new ArrayList<>();
        JSONArray jaItems = (JSONArray) objItems;
        inventory.addAll(jaItems);

        for (Object obItems:
                inventory) {
            JSONObject inventoryItem = (JSONObject) obItems;
            Item questItem;
            questItem = new Item((String) inventoryItem.get("name"), (String) inventoryItem.get("desc"), (Long) inventoryItem.get("value"));
            items.add(questItem);
        }
        return items;
    }

    public static Collection<Player> getNpcs() throws IOException, ParseException {
        Object charaobj = new JSONParser().parse(new FileReader("src/com/JsonObjects/characterList.json"));
        Collection<Object> charjson = new ArrayList<>();
        Collection<Player> npcs = new ArrayList<>();
        JSONArray ch = (JSONArray) charaobj;
        charjson.addAll(ch);
        for (Object cha: charjson
        ) {
            JSONObject character = (JSONObject) cha;
            Player npc = new Player((String) character.get("name"), (Long) character.get("hp"), (Long) character.get("attack"));
            npcs.add(npc);
        }
        return npcs;
    }

    public static Collection<Room> getMap() throws IOException, ParseException {
        Collection<Object> rooms = new ArrayList<>();
        Collection<Room> map = new ArrayList<>();
        Object obj = new JSONParser().parse(new FileReader("src/com/JsonObjects/rooms.json"));
        JSONArray ja = (JSONArray) obj;
        rooms.addAll(ja);
        for (Object ob:
                rooms) {
            JSONObject room = (JSONObject) ob;
            Room rm = new Room((String) room.get("name"), (String) room.get("desc"));
            map.add(rm);
        }
        return map;
    }
    public static Collection<Item> getWeapons() throws IOException, ParseException {
        Object objItems = new JSONParser().parse(new FileReader("src/com/JsonObjects/weapons.json"));
        Collection<Object> inventory = new ArrayList<>();
        Collection<Item> weapons = new ArrayList<>();
        JSONArray jaItems = (JSONArray) objItems;
        inventory.addAll(jaItems);

        for (Object obItems:
                inventory) {
            JSONObject inventoryItem = (JSONObject) obItems;
            Item questItem;
            questItem = new Weapons((String) inventoryItem.get("name"), (String) inventoryItem.get("desc"), (Long) inventoryItem.get("value"), (Long) inventoryItem.get("attack"));
            weapons.add(questItem);
        }
        return weapons;
    }
    public static Collection<Item> getArmor() throws IOException, ParseException {
        Object objItems = new JSONParser().parse(new FileReader("src/com/JsonObjects/armor.json"));
        Collection<Object> inventory = new ArrayList<>();
        Collection<Item> armor = new ArrayList<>();
        JSONArray jaItems = (JSONArray) objItems;
        inventory.addAll(jaItems);

        for (Object obItems:
                inventory) {
            JSONObject inventoryItem = (JSONObject) obItems;
            Item questItem;
            questItem = new Armor((String) inventoryItem.get("name"), (String) inventoryItem.get("desc"), (Long) inventoryItem.get("value"), (Long) inventoryItem.get("defense"));
            armor.add(questItem);
        }
        return armor;
    }
}
