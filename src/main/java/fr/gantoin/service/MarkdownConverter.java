package fr.gantoin.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class MarkdownConverter {

    public static Path convertToHtml(Path path, Path output) throws IOException {
        String markdownContent = Files.readString(path, StandardCharsets.UTF_8);
        MutableDataSet options = new MutableDataSet();
        com.vladsch.flexmark.parser.Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(markdownContent);
        String outputHtml = renderer.render(document);
        // add  one top level element to the document
        outputHtml = "<div class=\"markdown-body\">" + outputHtml + "</div>";
        OpenOption[] optionsArray = new OpenOption[0];
        Files.writeString(output, outputHtml, StandardCharsets.UTF_8, optionsArray);
        return output;
    }
}
