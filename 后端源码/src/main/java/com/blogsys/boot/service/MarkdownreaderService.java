package com.blogsys.boot.service;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
/*import com.vladsch.flexmark.util.options.MutableDataSet;
* */
import com.vladsch.flexmark.util.data.MutableDataSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;

@Slf4j
@Service
public class MarkdownreaderService {
    public String ReadInMarkdown(String filepath){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String context_in = br.readLine();
            StringBuilder all = new StringBuilder();
            all.append(context_in);
            while(context_in!=null){
                context_in = br.readLine();
                all.append('\n');
                if(context_in!=null)all.append(context_in);
            }
            return all.toString();
        }
        catch(Exception e){
            log.info("markdownreader Service：读取Markdown文件发生错误");
            return "";
        }
    }

    public String MarkdownConvertHtml(String filepath){
        String content = this.ReadInMarkdown(filepath);
        return this.parse(content);
    }

    public String parse(String content) {
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        //enable table parse!
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(content);
        return renderer.render(document);
    }
}
