package Structural.Facade.Java;

class FileReader {
    public String read(String filePath) {
        System.out.println("Reading file: " + filePath);
        return "RAW_CONTENT";
    }
}

class FormatValidator {
    public boolean validate(String filePath) {
        System.out.println("Validating file: " + filePath);
        return filePath.endsWith(".docx") || filePath.endsWith(".txt");
    }
}

class PDFConverter {
    public String convertToPDF(String content) {
        System.out.println("Converting to PDF");
        return "PDF_CONTENT";
    }
}

class DOCXConverter {
    public String convertToDOCX(String content) {
        System.out.println("Converting to DOCX");
        return "DOCX_CONTENT";
    }
}

class Logger {
    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

// The Facade hides away the bigger mess, so the user doesn't deal with
class FileConverterFacade {
    private final FileReader reader = new FileReader();
    private final FormatValidator validator = new FormatValidator();
    private final PDFConverter pdfConverter = new PDFConverter();
    private final DOCXConverter docxConverter = new DOCXConverter();
    private final Logger logger = new Logger();

    public String convert(String inputFilePath, String outputFormat) {
        logger.log("Starting conversion of " + inputFilePath + " to " + outputFormat.toUpperCase());

        if (!validator.validate(inputFilePath)) {
            throw new IllegalArgumentException("Unsupported input file format");
        }

        String content = reader.read(inputFilePath);

        switch (outputFormat.toLowerCase()) {
            case "pdf":
                return pdfConverter.convertToPDF(content);
            case "docx":
                return docxConverter.convertToDOCX(content);
            default:
                throw new UnsupportedOperationException("Unsupported output format: " + outputFormat);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FileConverterFacade converter = new FileConverterFacade();
        String output = converter.convert("input.docx", "pdf");

        System.out.println("Final Output: " + output);
    }
}
