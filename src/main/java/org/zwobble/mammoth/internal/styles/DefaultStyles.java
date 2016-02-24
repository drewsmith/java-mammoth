package org.zwobble.mammoth.internal.styles;

import com.google.common.collect.ImmutableList;
import org.zwobble.mammoth.internal.styles.parsing.StyleMapParser;

public class DefaultStyles {
    public static final StyleMap DEFAULT_STYLE_MAP = StyleMapParser.parse(ImmutableList.of(
        "p.Heading1 => h1:fresh",
        "p.Heading2 => h2:fresh",
        "p.Heading3 => h3:fresh",
        "p.Heading4 => h4:fresh",
        "p[style-name='Heading 1'] => h1:fresh",
        "p[style-name='Heading 2'] => h2:fresh",
        "p[style-name='Heading 3'] => h3:fresh",
        "p[style-name='Heading 4'] => h4:fresh",
        "p[style-name='heading 1'] => h1:fresh",
        "p[style-name='heading 2'] => h2:fresh",
        "p[style-name='heading 3'] => h3:fresh",
        "p[style-name='heading 4'] => h4:fresh",
        "p[style-name='heading 4'] => h4:fresh",

        "r[style-name='Strong'] => strong",

        "p[style-name='footnote text'] => p",
        "r[style-name='footnote reference'] =>",
        "p[style-name='endnote text'] => p",
        "r[style-name='endnote reference'] =>",

        // LibreOffice
        "p[style-name='Footnote'] => p",
        "r[style-name='Footnote anchor'] =>",
        "p[style-name='Endnote'] => p",
        "r[style-name='Endnote anchor'] =>",

        "p:unordered-list(1) => ul > li:fresh",
        "p:unordered-list(2) => ul|ol > li > ul > li:fresh",
        "p:unordered-list(3) => ul|ol > li > ul|ol > li > ul > li:fresh",
        "p:unordered-list(4) => ul|ol > li > ul|ol > li > ul|ol > li > ul > li:fresh",
        "p:unordered-list(5) => ul|ol > li > ul|ol > li > ul|ol > li > ul|ol > li > ul > li:fresh",
        "p:ordered-list(1) => ol > li:fresh",
        "p:ordered-list(2) => ul|ol > li > ol > li:fresh",
        "p:ordered-list(3) => ul|ol > li > ul|ol > li > ol > li:fresh",
        "p:ordered-list(4) => ul|ol > li > ul|ol > li > ul|ol > li > ol > li:fresh",
        "p:ordered-list(5) => ul|ol > li > ul|ol > li > ul|ol > li > ul|ol > li > ol > li:fresh",

        "r[style-name='Hyperlink'] =>",

        "p[style-name='Normal'] => p:fresh"));
}