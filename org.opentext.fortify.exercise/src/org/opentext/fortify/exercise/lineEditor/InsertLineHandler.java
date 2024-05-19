package org.opentext.fortify.exercise.lineEditor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.texteditor.ITextEditor;
import org.opentext.fortify.exercise.util.EditorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertLineHandler extends AbstractHandler {
	private static final Logger logger = LoggerFactory.getLogger(InsertLineHandler.class);
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            int lineNumber = Integer.parseInt(event.getParameter("insertRowN")) - 1;
            String newLine = event.getParameter("newLine");
            ITextEditor editor = EditorUtil.getActiveTextEditor();
            if (editor != null) {
                IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                EditorUtil.insertLine(document, lineNumber, newLine);
            }
        } catch (Exception e) {
        	logger.error("Invalid line number format", e);
        }
        return null;
    }
}