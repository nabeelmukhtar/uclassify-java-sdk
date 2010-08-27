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

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.uclassify.client.UClassifyClient;
import com.google.code.uclassify.client.UClassifyClientFactory;

/**
 * The Class ClassifierExample.
 * 
 * @author Nabeel Mukhtar
 */
public class ClassifierExample {

    /** Consumer Key. */
    private static final String WRITE_KEY = "writeKey";
	
    /** ID. */
    private static final String CLASSIFIER = "classifier";
    
    /** Name of the help command line option. */
    private static final String HELP_OPTION = "help";
    
    /**
     * The main method.
     * 
     * @param args the args
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
     * 
     * @param line the line
     * @param options the options
     */
    private static void processCommandLine(CommandLine line, Options options) {
        if(line.hasOption(HELP_OPTION)) {
            printHelp(options);            
        } else if(line.hasOption(WRITE_KEY)) {
    		final String writeKeyValue = line.getOptionValue(WRITE_KEY);
    		
    		final UClassifyClientFactory factory = UClassifyClientFactory.newInstance(null, writeKeyValue);
    		final UClassifyClient client = factory.createUClassifyClient();
    		
    		if(line.hasOption(CLASSIFIER)) {
    			String classifier = line.getOptionValue(CLASSIFIER);
    			System.out.println("Creating classifier:" + classifier);
    			client.createClassifier(classifier);
    			client.addClass(classifier, "ClassA");
    			client.addClass(classifier, "ClassB");
    			client.addClass(classifier, "ClassC");
    			client.addClass(classifier, "ClassD");
				System.out.println("Classifier created.");
				System.out.println("Press D to remove this classifier. Press any other key to continue.");
				try {
					int read = System.in.read();
					if (read == (int) 'D') {
						client.removeClassifier(classifier);
						System.out.println("Deleted classifier:" + classifier);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
        } else {
            printHelp(options);
        }
    }
	
	/**
	 * Build command line options object.
	 * 
	 * @return the options
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
        
        return opts;
    }
    
    /**
     * Print help and usage.
     * 
     * @param options the options
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = ClassifierExample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0}, -{1}, -{2} and -{3} options are required. All others are optional.", WRITE_KEY);
        String footer = MessageFormat.format("\nIf you do not specify any of -{0} or -{1} options, the profile of current user is returned. You can only specify one of these options. If you do not specify -{2} option, standard profile is returned.", CLASSIFIER);
        new HelpFormatter().printHelp(width, syntax, header, options, footer, false);
    }
}
