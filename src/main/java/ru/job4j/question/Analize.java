package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int deleted;
        int changed = 0;

        Map<Integer, String> map = new HashMap<>(previous.size());
        previous.forEach(user -> map.put(user.getId(), user.getName()));
        for (User currents : current) {
            if (map.containsKey(currents.getId())) {
                if (!map.containsValue(currents.getName())) {
                    changed++;
                }
            } else {
                added++;
            }
        }
        deleted = Math.abs(current.size() - previous.size() - added);
        return new Info(added, changed, deleted);
        }
    }
