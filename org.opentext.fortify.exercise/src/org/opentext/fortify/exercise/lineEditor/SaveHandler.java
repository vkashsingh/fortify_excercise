package org.opentext.fortify.exercise.lineEditor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.texteditor.ITextEditor;
import org.opentext.fortify.exercise.util.EditorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveHandler extends AbstractHandler {
	 private static final Logger logger = LoggerFactory.getLogger(SaveHandler.class);
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ITextEditor editor = EditorUtil.getActiveTextEditor();
        if (editor != null) {
            try {
                editor.doSave(null);
            } catch (Exception e) {
                logger.error("Error saving document", e);
            }
        }
        return null;
    }
}