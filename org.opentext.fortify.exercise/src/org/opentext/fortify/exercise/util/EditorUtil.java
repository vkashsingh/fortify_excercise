package org.opentext.fortify.exercise.util;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;

public class EditorUtil {

    public static ITextEditor getActiveTextEditor() {
        IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return (activeEditor instanceof ITextEditor) ? (ITextEditor) activeEditor : null;
    }

    public static void replaceLine(IDocument document, int lineNumber, String newText) throws Exception {
        int startOffset = document.getLineOffset(lineNumber);
        int length = document.getLineLength(lineNumber);
        document.replace(startOffset, length, newText);
    }

    public static void insertLine(IDocument document, int lineNumber, String newText) throws Exception {
        int startOffset = document.getLineOffset(lineNumber);
        document.replace(startOffset, 0, newText + "\n");
    }

    public static void deleteLine(IDocument document, int lineNumber) throws Exception {
        int startOffset = document.getLineOffset(lineNumber);
        int length = document.getLineLength(lineNumber);
        document.replace(startOffset, length, "");
    }
}