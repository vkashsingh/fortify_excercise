package org.opentext.fortify.exercise.lineEditor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.texteditor.ITextEditor;
import org.opentext.fortify.exercise.util.EditorUtil;

public class ListHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ITextEditor editor = EditorUtil.getActiveTextEditor();
		if (editor != null) {
			IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
			printDocumentLines(document);
		}
		return null;
	}

	private void printDocumentLines(IDocument document) {
		String[] lines = document.get().split("\n");
		for (int i = 0; i < lines.length; i++) {
			System.out.println((i + 1) + ": " + lines[i]);
		}
	}
}