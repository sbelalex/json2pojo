package json2pojo;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;
import org.jsonschema2pojo.AnnotationStyle;
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

    static JCodeModel codeModel = new JCodeModel();
    static File input = new File("input");
    static File output = new File(new File("output"), "dto");

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
	    return AnnotationStyle.GSON;
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

    static SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new GsonAnnotator(), new SchemaStore()),
	    new SchemaGenerator());

    public static void main(String[] args) throws IOException {

	output.mkdirs();
	output.mkdir();

	for (File file : input.listFiles()) {
	    if (file.isFile()) {
		generatePojos(file);
	    }
	}

    }

    static void generatePojos(File file) throws IOException {

	String baseName = FilenameUtils.getBaseName(file.getAbsolutePath());

	URL url = file.toURI().toURL();
	String subPackage = baseName.toLowerCase();
	mapper.generate(codeModel, baseName, subPackage, url);

	codeModel.build(output);
    }

}
