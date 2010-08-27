/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.uclassify.client.examples;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.uclassify.client.UClassifyClient;
import com.google.code.uclassify.client.UClassifyClientFactory;
import com.uclassify.api._1.responseschema.Class;
import com.uclassify.api._1.responseschema.Classification;

/**
 * @author Nabeel Mukhtar
 *
 */
public class ClassifyExample {

    /**
     * Consumer Key
     */
    private static final String READ_KEY = "readKey";
	
    /**
     * ID
     */
    private static final String CLASSIFIER = "classifier";
    
    /**
     * Profile Type
     */
    private static final String USER = "user";
    
    /**
     * Profile Type
     */
    private static final String TEXT = "text";
    
    /**
     * Name of the help command line option.
     */
    private static final String HELP_OPTION = "help";
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		Options options = buildOptions();
        try {
            CommandLine line = new BasicParser().parse(options, args);
            processCommandLine(line, options);
        } catch(ParseException exp ) {
            System.err.println(exp.getMessage());
            printHelp(options);
        }
	}
	
    /**
     * Process command line options and call the service. 
     */
    private static void processCommandLine(CommandLine line, Options options) {
        if(line.hasOption(HELP_OPTION)) {
            printHelp(options);            
        } else if(line.hasOption(READ_KEY)) {
    		final String readKeyValue = line.getOptionValue(READ_KEY);
    		
    		final UClassifyClientFactory factory = UClassifyClientFactory.newInstance(readKeyValue, null);
    		final UClassifyClient client = factory.createUClassifyClient();
    		
    		if(line.hasOption(CLASSIFIER) && line.hasOption(TEXT)) {
    			String classifier = line.getOptionValue(CLASSIFIER);
    			String text = line.getOptionValue(TEXT);
    			System.out.println("Fetching classification for classifier:" + classifier);
    			if (line.hasOption(USER)) {
    				String user = line.getOptionValue(USER);
        			Map<String, Classification> classifications = client.classify(user, classifier, Arrays.asList(text));
        			printResult(classifications);
    			} else {
        			Map<String, Classification> classifications = client.classify(classifier, Arrays.asList(text));
        			printResult(classifications);
    			}
    		}
        } else {
            printHelp(options);
        }
    }
	
	private static void printResult(Map<String, Classification> classifications) {
		for(String category : classifications.keySet()) {
			Classification classification = classifications.get(category);
			System.out.println(category);
			for (Class clazz : classification.getClazz()) {
				System.out.println(clazz.getClassName() + ":" + clazz.getP());
			}
		}
	}

	/**
     * Build command line options object.
     */
    private static Options buildOptions() {
       
        Options opts = new Options();
        
        String helpMsg = "Print this message.";
        Option help = new Option(HELP_OPTION, helpMsg);
        opts.addOption(help);

        String consumerKeyMsg = "You API Read Key.";
        OptionBuilder.withArgName("readKey");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(consumerKeyMsg);
        Option consumerKey = OptionBuilder.create(READ_KEY);
        opts.addOption(consumerKey);
        
        String idMsg = "Classifier Name";
        OptionBuilder.withArgName("classifier");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(idMsg);
        Option id = OptionBuilder.create(CLASSIFIER);
        opts.addOption(id);
        
        String urlMsg = "Text to be classified.";
        OptionBuilder.withArgName("text");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(urlMsg);
        Option url = OptionBuilder.create(TEXT);
        opts.addOption(url);
        
        String typeMsg = "User who owns the classifier.";
        OptionBuilder.withArgName("user");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(typeMsg);
        Option type = OptionBuilder.create(USER);
        opts.addOption(type);
        
        return opts;
    }
    
    /**
     * Print help and usage.
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = ClassifyExample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0}, -{1}, -{2} and -{3} options are required. All others are optional.", READ_KEY);
        String footer = MessageFormat.format("\nIf you do not specify any of -{0} or -{1} options, the profile of current user is returned. You can only specify one of these options. If you do not specify -{2} option, standard profile is returned.", CLASSIFIER, TEXT, USER);
        new HelpFormatter().printHelp(width, syntax, header, options, footer, false);
    }
}
