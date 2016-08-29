package json2pojo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.jsonschema2pojo.AnnotationStyle;
import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.GsonAnnotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

import com.sun.codemodel.JCodeModel;

public class PojoGenerator {

	static AnnotationStyle annotationStyle = AnnotationStyle.GSON;
	static Annotator annotator = new GsonAnnotator();

	static JCodeModel codeModel = new JCodeModel();
	static File input = new File("input");
	static String pkg;

	static GenerationConfig config = new DefaultGenerationConfig() {

		@Override
		public boolean isGenerateBuilders() {
			return true;
		}

		@Override
		public boolean isIncludeHashcodeAndEquals() {
			return true;
		}

		@Override
		public boolean isIncludeToString() {
			return true;
		}

		@Override
		public boolean isUseCommonsLang3() {
			return true;
		}

		@Override
		public boolean isParcelable() {
			return true;
		}

		@Override
		public boolean isSerializable() {
			return true;
		}

		@Override
		public boolean isIncludeConstructors() {
			return true;
		}

		@Override
		public boolean isIncludeAdditionalProperties() {
			return true;
		}

		@Override
		public boolean isIncludeAccessors() {
			return true;
		}

		@Override
		public AnnotationStyle getAnnotationStyle() {
			return annotationStyle;
		}

		@Override
		public SourceType getSourceType() {
			return SourceType.JSON;
		}

		@Override
		public boolean isUseBigDecimals() {
			return true;
		}
	};

	static SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, annotator, new SchemaStore()),
			new SchemaGenerator());

	public static void main(String[] args) {

		// greet and ask the project name (will be used for output dir)
		System.out.println("Welcome to json2pojo! Please enter the DTO package...");
		Scanner in = new Scanner(System.in);
		pkg = in.nextLine();

		File output = new File("output");

		// ask the user if we should clear out the output directory
		String proceed;
		do {
			System.out.println("Do you want to clear the output directory? (Y/N)...");
			proceed = in.nextLine();
		} while (!proceed.equalsIgnoreCase("Y") && !proceed.equalsIgnoreCase("N"));

		// done taking input
		in.close();

		// clear the output directory if it exists
		if (proceed.equalsIgnoreCase("Y")) {
			if (output.exists()) {
				try {
					FileUtils.cleanDirectory(output);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// create the output directory
		output.mkdirs();
		output.mkdir();

		// for each file in the input directory
		for (File file : input.listFiles()) {
			
			// if the file is a file (not a directory)
			if (file.isFile()) {
				
				// ignore .DS_Store on Mac
				String ext = FilenameUtils.getExtension(file.getName());
				if (ext.equalsIgnoreCase("ds_store")) {
					continue;
				}
				
				// try to generate pojos
				try {
					generatePojos(file, output);
				} catch (Exception e) {
					System.out.println("Error on file: " + file.getAbsolutePath());
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Takes a JSON file, converts it to a POJO, and saves it to the specified
	 * directory
	 * 
	 * @param file
	 *            The file to be converted (.json or .txt)
	 * @param output
	 *            The output directory
	 * @throws IOException
	 */
	static void generatePojos(File file, File output) throws IOException {

		String baseName = FilenameUtils.getBaseName(file.getAbsolutePath());
		String packageName = pkg + "." + baseName.toLowerCase();
		URL url = file.toURI().toURL();

		mapper.generate(codeModel, baseName, packageName, url);
		codeModel.build(output);
	}

}
