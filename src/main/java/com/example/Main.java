package com.example;

import com.google.common.collect.Collections2;
import de.vandermeer.asciitable.AT_Context;
import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.document.TableRowStyle;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.list.TreeList;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        var base = Map.of(
                1L, new Student("Ali", 15),
                4L, new Student("Mohammad", 16),
                3L, new Student("Reza", 17),
                2L, new Student("Ahamd", 15)
        );

        var map = sortMap(base);

        final AT_Context ctx = new AT_Context();
        ctx.setFrameTopChar('A');

        var ref = new Object() {
            AsciiTable at = new AsciiTable(ctx);
        };
        ref.at.addRule();
        final AT_Row header = ref.at.addRow("ID", "NAME", "AGE");
        header.setTextAlignment(TextAlignment.CENTER);
        ref.at.addRule();

        TerminalColor.println(TerminalColor.GREEN_BOLD, ref.at.render());

        ref.at = new AsciiTable();

        map.forEach((x, y) -> {
            ref.at.addRow(x, y.getName(), y.getAge());
            ref.at.addRule();
            ref.at.setTextAlignment(TextAlignment.CENTER);
        });

        TerminalColor.println(TerminalColor.YELLOW, ref.at.render());

    }

    private static <T extends Number, R extends Comparable<R>> TreeMap<T, R> sortMap(Map<T, R> base) {
        final Comparator<Long> comparator = new Comparator<>() {
            @Override
            public int compare(Long a, Long b) {
                return base.get(a).compareTo(base.get(b));
            }
        };

        final TreeMap<T, R> map = new TreeMap(comparator);
        map.putAll(base);
        return map;
    }
}
