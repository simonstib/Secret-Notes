/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretnotes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import secretnotes.Controllers.Controller;
import secretnotes.model.Model;
import secretnotes.views.BaseView;

/**
 *
 * @author MSimons
 */
public class SecretNotes extends JFrame {

    public SecretNotes() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final SecretNotes count = new SecretNotes();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model(0);
                BaseView view = new BaseView("-");
                Controller controller = new Controller(model, view);
                controller.setButtonListeners();

            }
        });

    }

}
