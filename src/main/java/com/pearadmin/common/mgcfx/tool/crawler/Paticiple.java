package com.pearadmin.common.mgcfx.tool.crawler;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class Paticiple {
    /**
     * 本类是分词类，借用第三方分词工具包处理文本
     * @param text   所需分词的文本
     * @return  返回分词后的文本
     * @throws Exception
     */

//分词工具
    public static ArrayList<String> fenci(String text) throws Exception {


        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, true);
        Lexeme lex;
        ArrayList<String> s = new ArrayList<>();
        while ((lex = ik.next()) != null) {
            s.add(lex.getLexemeText());
        }
        return s;
    }

}
