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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.uclassify.client.UClassifyClient;
import com.google.code.uclassify.client.UClassifyClientFactory;
import com.uclassify.api._1.responseschema.ClassInformation;

/**
 * @author Nabeel Mukhtar
 *
 */
public class TrainExample {

    /**
     * Consumer Key
     */
    private static final String WRITE_KEY = "writeKey";
	
    /**
     * ID
     */
    private static final String CLASSIFIER = "classifier";
    
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
        } else if(line.hasOption(WRITE_KEY)) {
    		final String writeKeyValue = line.getOptionValue(WRITE_KEY);
    		
    		final UClassifyClientFactory factory = UClassifyClientFactory.newInstance(null, writeKeyValue);
    		final UClassifyClient client = factory.createUClassifyClient();
    		
    		if(line.hasOption(CLASSIFIER) && line.hasOption(TEXT)) {
    			String classifier = line.getOptionValue(CLASSIFIER);
    			String textFile = line.getOptionValue(TEXT);
    			System.out.println("Classifying classifier:" + classifier);
    			try {
					client.train(classifier, new FileInputStream(textFile));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("Training complete.");
//    			List<ClassInformation> informations = client.getInformation(classifier);
//    			printResult(informations);
    		}
        } else {
            printHelp(options);
        }
    }
	
	private static void printResult(List<ClassInformation> informations) {
		System.out.println("===================== Classifier Info ========================");
		System.out.println("Class Name:Total Count:Unique Features");
		for (ClassInformation classInformation : informations) {
			System.out.println(classInformation.getClassName() + ":" + classInformation.getTotalCount() + ":" + classInformation.getUniqueFeatures());
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

        String consumerKeyMsg = "You API Write Key.";
        OptionBuilder.withArgName("readKey");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(consumerKeyMsg);
        Option consumerKey = OptionBuilder.create(WRITE_KEY);
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
        
        return opts;
    }
    
    /**
     * Print help and usage.
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = TrainExample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0}, -{1}, -{2} and -{3} options are required. All others are optional.", WRITE_KEY);
        String footer = MessageFormat.format("\nIf you do not specify any of -{0} or -{1} options, the profile of current user is returned. You can only specify one of these options. If you do not specify -{2} option, standard profile is returned.", CLASSIFIER, TEXT);
        new HelpFormatter().printHelp(width, syntax, header, options, footer, false);
    }
}
