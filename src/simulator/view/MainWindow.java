package simulator.view;

import simulator.view.EventsTableModel;
import simulator.control.Controller;
import simulator.view.MapComponent;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private Controller _ctrl;

    public MainWindow(Controller ctrl) {
        super("Traffic Simulator");
        _ctrl = ctrl;
        initGUI();
    }

    private void initGUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        this.setContentPane(mainPanel);

        mainPanel.add(new ControlPanel(_ctrl), BorderLayout.PAGE_START);
        mainPanel.add(new StatusBar(_ctrl), BorderLayout.PAGE_END);

        JPanel viewsPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.add(viewsPanel, BorderLayout.CENTER);

        JPanel tablesPanel = new JPanel();
        tablesPanel.setLayout(new BoxLayout(tablesPanel, BoxLayout.Y_AXIS));
        viewsPanel.add(tablesPanel);

        JPanel mapsPanel = new JPanel();
        mapsPanel.setLayout(new BoxLayout(mapsPanel, BoxLayout.Y_AXIS));
        viewsPanel.add(mapsPanel);



        //tables
        JPanel eventsView = createViewPanel(new JTable(new EventsTableModel(_ctrl)), "Events");
        eventsView.setPreferredSize(new Dimension(500, 200));
        eventsView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        eventsView.setBorder(BorderFactory.createTitledBorder("Events"));
        tablesPanel.add(eventsView);

        JPanel vehiclesView = createViewPanel( new JTable( new VehiclesTableModel( _ctrl )), "Vehicles" );
        vehiclesView.setPreferredSize(new Dimension(500, 200));
        vehiclesView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        vehiclesView.setBorder(BorderFactory.createTitledBorder("Vehicles"));
        tablesPanel.add(vehiclesView);

        JPanel roadsView = createViewPanel( new JTable( new RoadsTableModel( _ctrl )), "Roads" );
        roadsView.setPreferredSize(new Dimension(500, 200));
        roadsView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        roadsView.setBorder(BorderFactory.createTitledBorder("Roads"));
        tablesPanel.add(roadsView);

        JPanel junctionsView = createViewPanel( new JTable( new JunctionsTableModel( _ctrl )), "Junctions");
        junctionsView.setPreferredSize(new Dimension(500, 200));
        junctionsView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        junctionsView.setBorder(BorderFactory.createTitledBorder("Junctions"));
        tablesPanel.add(junctionsView);



        // maps
        JPanel mapView = createViewPanel(new MapComponent(_ctrl), "Map");
        mapView.setPreferredSize(new Dimension(500, 400));
        mapsPanel.add(mapView);

        //TODO add a map for MapByRoadComponent
        JPanel mapByRoadView = createViewPanel(new MapByRoadComponent(_ctrl), "Map By Road");
        mapsPanel.add(mapByRoadView);


        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private JPanel createViewPanel(JComponent c, String title) {
        JPanel p = new JPanel(new BorderLayout());
        //TODO add a framed border to p with title
        p.add(new JScrollPane(c));
        return p;
    }
}