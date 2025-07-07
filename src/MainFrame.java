import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel contentPane;
	private JTable userTable;
	private JTable adminTable;
	private JTextField txtBarcode;
	private JTextField txtBrand;
	private JTextField txtColor;
	private JTextField txtQuantity;
	private JTextField txtOriginalCost;
	private JTextField txtRetailPrice;
	private JTextField txtAdditionalInfo;
	private JTable customerTable;
	private JTextField txtSearchBarcode;
	private JTextField txtMouseButtons;
	private JTable basketTable;
	private JTextField txtRemoveBarcode;
	private List<Integer> selectedBarcodes = new ArrayList<>();
	private JTextField txtCardNumber;
	private JTextField txtSecurityCode;
	private JTextField txtEmail;
	private JLabel lblTotalAmount;
	private JLabel lblAddress;
	private JLabel lblDate;
	private JLabel lblEmailOrCardlbl;
	private JLabel lblEmailOrCard;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 966, 543);
		contentPane.add(tabbedPane);

		JPanel panel_Menu = new JPanel();
		tabbedPane.addTab("Menu", null, panel_Menu, null);
		panel_Menu.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setBounds(30, 87, 900, 395);
		panel_Menu.add(scrollPane);

		userTable = new JTable();
		userTable.setBounds(30, 87, 900, 395);
		scrollPane.setViewportView(userTable);

		JLabel lblSelectUser = new JLabel("Select a user:");
		lblSelectUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectUser.setBounds(30, 37, 307, 25);
		panel_Menu.add(lblSelectUser);

		JPanel panel_Admin = new JPanel();
		tabbedPane.addTab("Admin", null, panel_Admin, null);
		panel_Admin.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 82, 690, 412);
		panel_Admin.add(scrollPane_1);

		adminTable = new JTable();
		adminTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane_1.setViewportView(adminTable);

		JLabel lblBarcode = new JLabel("Barcode:");
		lblBarcode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBarcode.setBounds(726, 168, 45, 13);
		panel_Admin.add(lblBarcode);

		txtBarcode = new JTextField();
		txtBarcode.setBounds(808, 165, 126, 19);
		panel_Admin.add(txtBarcode);
		txtBarcode.setColumns(10);

		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBrand.setBounds(726, 191, 45, 13);
		panel_Admin.add(lblBrand);

		txtBrand = new JTextField();
		txtBrand.setBounds(808, 188, 126, 19);
		panel_Admin.add(txtBrand);
		txtBrand.setColumns(10);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblColor.setBounds(726, 214, 45, 13);
		panel_Admin.add(lblColor);

		txtColor = new JTextField();
		txtColor.setBounds(808, 211, 126, 19);
		panel_Admin.add(txtColor);
		txtColor.setColumns(10);

		JLabel lblConnectivity = new JLabel("Connectivity:");
		lblConnectivity.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblConnectivity.setBounds(726, 237, 63, 13);
		panel_Admin.add(lblConnectivity);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblQuantity.setBounds(726, 260, 45, 13);
		panel_Admin.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setBounds(808, 257, 126, 19);
		panel_Admin.add(txtQuantity);
		txtQuantity.setColumns(10);

		JLabel lblOriginalCost = new JLabel("Original Cost: ");
		lblOriginalCost.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOriginalCost.setBounds(726, 283, 72, 13);
		panel_Admin.add(lblOriginalCost);

		txtOriginalCost = new JTextField();
		txtOriginalCost.setBounds(808, 280, 126, 19);
		panel_Admin.add(txtOriginalCost);
		txtOriginalCost.setColumns(10);

		JLabel lblRetailPrice = new JLabel("Retail Price: ");
		lblRetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRetailPrice.setBounds(726, 306, 63, 13);
		panel_Admin.add(lblRetailPrice);

		txtRetailPrice = new JTextField();
		txtRetailPrice.setBounds(808, 303, 126, 19);
		panel_Admin.add(txtRetailPrice);
		txtRetailPrice.setColumns(10);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCategory.setBounds(726, 329, 45, 13);
		panel_Admin.add(lblCategory);

		JLabel lblDeviceType = new JLabel("Device Type:");
		lblDeviceType.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDeviceType.setBounds(726, 352, 63, 13);
		panel_Admin.add(lblDeviceType);

		JLabel lblAdditionalInfo = new JLabel("Additional Info:");
		lblAdditionalInfo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAdditionalInfo.setBounds(726, 375, 72, 13);
		panel_Admin.add(lblAdditionalInfo);

		txtAdditionalInfo = new JTextField();
		txtAdditionalInfo.setBounds(808, 372, 126, 19);
		panel_Admin.add(txtAdditionalInfo);
		txtAdditionalInfo.setColumns(10);

		JLabel lblAddProducts = new JLabel("Add Product:");
		lblAddProducts.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddProducts.setBounds(726, 118, 126, 25);
		panel_Admin.add(lblAddProducts);

		JLabel lblAllProducts = new JLabel("All Products:");
		lblAllProducts.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAllProducts.setBounds(26, 41, 126, 31);
		panel_Admin.add(lblAllProducts);

		JLabel lblErrors = new JLabel("");
		lblErrors.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblErrors.setBounds(726, 401, 208, 53);
		panel_Admin.add(lblErrors);

		JComboBox<ConnectivityType> comboBoxConnectivity = new JComboBox<ConnectivityType>();
		comboBoxConnectivity.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBoxConnectivity.setBounds(808, 233, 126, 21);
		panel_Admin.add(comboBoxConnectivity);
		for (ConnectivityType type : ConnectivityType.values()) {
			comboBoxConnectivity.addItem(type);
		}

		JComboBox<ProductCategory> comboBoxCategory = new JComboBox<ProductCategory>();
		comboBoxCategory.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBoxCategory.setBounds(808, 325, 126, 21);
		panel_Admin.add(comboBoxCategory);
		for (ProductCategory category : ProductCategory.values()) {
			comboBoxCategory.addItem(category);
		}

		JComboBox<DeviceType> comboBoxDeviceType = new JComboBox<DeviceType>();
		comboBoxDeviceType.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBoxDeviceType.setBounds(808, 348, 126, 21);
		panel_Admin.add(comboBoxDeviceType);
		for (DeviceType deviceType : DeviceType.values()) {
			comboBoxDeviceType.addItem(deviceType);
		}

		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAddProduct.setBounds(780, 461, 115, 21);
		panel_Admin.add(btnAddProduct);
		
		JButton btnToMenu_1 = new JButton("Back To Menu");
		btnToMenu_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnToMenu_1.setBounds(832, 10, 119, 21);
		panel_Admin.add(btnToMenu_1);
		btnToMenu_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loadCustomerTable();
            	tabbedPane.setEnabledAt(1, false);
            	tabbedPane.setEnabledAt(0, true); // Menu tab
            	tabbedPane.setSelectedIndex(0); //Menu tab	
            }
        });

		JPanel panel_Customer = new JPanel();
		tabbedPane.addTab("Customer", null, panel_Customer, null);
		panel_Customer.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(28, 90, 904, 385);
		panel_Customer.add(scrollPane_2);

		customerTable = new JTable();
		customerTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane_2.setViewportView(customerTable);

		JLabel lblProducts = new JLabel("Select products to add to basket:");
		lblProducts.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProducts.setBounds(29, 25, 302, 31);
		panel_Customer.add(lblProducts);

		JButton btnToBasket = new JButton("Go to basket");
		btnToBasket.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnToBasket.setBounds(821, 485, 111, 21);
		panel_Customer.add(btnToBasket);
		btnToBasket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	tabbedPane.setEnabledAt(3, true); // Basket tab
            	tabbedPane.setEnabledAt(2, false); // Customer tab
            	tabbedPane.setSelectedIndex(3); // Basket tab
            }
        });

		txtSearchBarcode = new JTextField();
		txtSearchBarcode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtSearchBarcode.setBounds(836, 61, 96, 19);
		panel_Customer.add(txtSearchBarcode);
		txtSearchBarcode.setColumns(10);

		txtSearchBarcode.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filterTableByBarcode();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filterTableByBarcode();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filterTableByBarcode();
			}
		});

		JLabel lblSearchBarcode = new JLabel("Search by barcode:");
		lblSearchBarcode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSearchBarcode.setBounds(730, 64, 96, 13);
		panel_Customer.add(lblSearchBarcode);

		txtMouseButtons = new JTextField();
		txtMouseButtons.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtMouseButtons.setBounds(613, 61, 96, 19);
		panel_Customer.add(txtMouseButtons);
		txtMouseButtons.setColumns(10);

		txtMouseButtons.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filterTableByMouseButtons();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filterTableByMouseButtons();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filterTableByMouseButtons();
			}
		});

		JLabel lblSearchMouse = new JLabel("Search by number of mouse buttons:");
		lblSearchMouse.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSearchMouse.setBounds(433, 64, 170, 13);
		panel_Customer.add(lblSearchMouse);
		
		JButton btnToMenu_2 = new JButton("Back To Menu");
		btnToMenu_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnToMenu_2.setBounds(813, 10, 119, 21);
		panel_Customer.add(btnToMenu_2);
		btnToMenu_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	selectedBarcodes.clear();
            	updateBasketTable();
            	tabbedPane.setEnabledAt(2, false);
            	tabbedPane.setEnabledAt(0, true); // Menu tab
            	tabbedPane.setSelectedIndex(0); //Menu tab
            }
        });

		JPanel panel_Basket = new JPanel();
		tabbedPane.addTab("Basket", null, panel_Basket, null);
		panel_Basket.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(29, 106, 904, 346);
		panel_Basket.add(scrollPane_3);

		basketTable = new JTable();
		scrollPane_3.setViewportView(basketTable);

		JLabel lblBasket = new JLabel("Basket:");
		lblBasket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBasket.setBounds(29, 40, 80, 33);
		panel_Basket.add(lblBasket);

		JLabel lblRemoveBarcode = new JLabel("Enter barcode to remove an item from the basket:");
		lblRemoveBarcode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRemoveBarcode.setBounds(29, 83, 230, 13);
		panel_Basket.add(lblRemoveBarcode);

		txtRemoveBarcode = new JTextField();
		txtRemoveBarcode.setBounds(269, 80, 96, 19);
		panel_Basket.add(txtRemoveBarcode);
		txtRemoveBarcode.setColumns(10);

		JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGo.setBounds(375, 79, 46, 21);
		panel_Basket.add(btnGo);
		btnGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		int BarcodeToRemove = Integer.parseInt(txtRemoveBarcode.getText());
            		for (int i = 0; i < selectedBarcodes.size(); i++) {
                        if (selectedBarcodes.get(i) == BarcodeToRemove) {
                            selectedBarcodes.remove(i);
                            break;
                        }
                    }
            		updateBasketTable();
            	} catch (NumberFormatException e2) {
            		txtRemoveBarcode.setText("");
            		return;
            	}
            	txtRemoveBarcode.setText("");
            	
            }
        });
		
		JButton btnClearAll = new JButton("Remove all items from basket");
		btnClearAll.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnClearAll.setBounds(738, 79, 195, 21);
		panel_Basket.add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	selectedBarcodes.clear(); //Clear all products in the basket
                updateBasketTable();
            }
        });
		
		JLabel lblIfEmpty = new JLabel("Basket is empty, add some items to proceed with payment");
		lblIfEmpty.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIfEmpty.setBounds(505, 466, 284, 13);
		panel_Basket.add(lblIfEmpty);

		JButton btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPay.setBounds(799, 462, 134, 21);
		panel_Basket.add(btnPay);
		
		btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (selectedBarcodes.isEmpty()) {
            		lblIfEmpty.setVisible(true);
            	} else {
            		tabbedPane.setEnabledAt(4, true); // Payment tab
            		tabbedPane.setEnabledAt(3, false); // Basket tab
            		tabbedPane.setSelectedIndex(4); //Payment tab
            	}
            }
        });
		
		JButton btnBackToProducts = new JButton("Back to Products");
		btnBackToProducts.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBackToProducts.setBounds(818, 10, 115, 21);
		panel_Basket.add(btnBackToProducts);
		lblIfEmpty.setVisible(false);
		
		btnBackToProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		tabbedPane.setEnabledAt(2, true); // Customer tab
            		tabbedPane.setEnabledAt(3, false); // Basket tab
            		tabbedPane.setSelectedIndex(2); // Customer tab
            }
        });
		
		JPanel panel_Payment = new JPanel();
		tabbedPane.addTab("Payment", null, panel_Payment, null);
		panel_Payment.setLayout(null);
		
		JLabel lblPayment = new JLabel("Payment:");
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPayment.setBounds(35, 29, 102, 38);
		panel_Payment.add(lblPayment);
		
		JLabel lblPayment2 = new JLabel("Pay by entering details for either Credit Card or PayPal:");
		lblPayment2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPayment2.setBounds(35, 77, 271, 13);
		panel_Payment.add(lblPayment2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(483, 134, 2, 345);
		panel_Payment.add(separator);
		
		JLabel lblCreditCard = new JLabel("Credit Card");
		lblCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCreditCard.setBounds(199, 134, 102, 21);
		panel_Payment.add(lblCreditCard);
		
		JLabel lblPayPal = new JLabel("PayPal");
		lblPayPal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPayPal.setBounds(694, 134, 58, 21);
		panel_Payment.add(lblPayPal);
		
		JLabel lblCardNo = new JLabel("Enter Card Number:");
		lblCardNo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCardNo.setBounds(92, 199, 107, 13);
		panel_Payment.add(lblCardNo);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtCardNumber.setBounds(199, 196, 171, 19);
		panel_Payment.add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		JLabel lblSecurityCode = new JLabel("Enter Security Code:");
		lblSecurityCode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSecurityCode.setBounds(92, 241, 107, 13);
		panel_Payment.add(lblSecurityCode);
		
		txtSecurityCode = new JTextField();
		txtSecurityCode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtSecurityCode.setBounds(199, 238, 171, 19);
		panel_Payment.add(txtSecurityCode);
		txtSecurityCode.setColumns(10);
		
		JLabel lblCreditCardError = new JLabel("");
		lblCreditCardError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCreditCardError.setBounds(152, 306, 184, 55);
		panel_Payment.add(lblCreditCardError);
		
		JButton btnCreditCard = new JButton("Pay By Credit Card");
		btnCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCreditCard.setBounds(170, 387, 136, 21);
		panel_Payment.add(btnCreditCard);
		
		btnCreditCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Get card number and security code
				String cardNumber = txtCardNumber.getText().trim();
				String securityCode = txtSecurityCode.getText().trim();
				PayWithCreditCard payWithCreditCard = new PayWithCreditCard();
				// Check to make sure the inputs are valid
				String resultMsg = payWithCreditCard.validateData(cardNumber, securityCode);
				if (resultMsg != "") {
					// Inform user of error
					lblCreditCardError.setText("<html>" + resultMsg + "</html>");
				} else {
					tabbedPane.setEnabledAt(5, true); // Receipt tab
					tabbedPane.setEnabledAt(4, false); // Payment tab
					tabbedPane.setSelectedIndex(5); // Receipt tab
					loadReceipt("Credit Card");
				}
			}
		});
		
		JLabel lblEmail = new JLabel("Enter Email Address:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEmail.setBounds(563, 199, 117, 13);
		panel_Payment.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEmail.setBounds(673, 196, 171, 19);
		panel_Payment.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPayPalError = new JLabel("Make sure email address is not empty");
		lblPayPalError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPayPalError.setBounds(638, 306, 184, 38);
		panel_Payment.add(lblPayPalError);
		lblPayPalError.setVisible(false);
		
		JButton btnPayPal = new JButton("Pay By PayPal");
		btnPayPal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPayPal.setBounds(658, 387, 136, 21);
		panel_Payment.add(btnPayPal);
		
		btnPayPal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get the email
				String email = txtEmail.getText().trim();;
				PayWithPayPal payWithPayPal = new PayWithPayPal();
				// Check to make sure input is valid
				Boolean msg = payWithPayPal.validateData(email);
				if (msg == false) {
					// Inform user of error
					lblPayPalError.setVisible(true);
				} else {
					tabbedPane.setEnabledAt(5, true); // Receipt tab
					tabbedPane.setEnabledAt(4, false); // Payment tab
					tabbedPane.setSelectedIndex(5); // Receipt tab
					loadReceipt("PayPal");
				}
			}
		});
		
		JButton btnBackToBasket = new JButton("Back to Basket");
		btnBackToBasket.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBackToBasket.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBackToBasket.setBounds(820, 10, 107, 21);
		panel_Payment.add(btnBackToBasket);
		
		btnBackToBasket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(3, true); // Basket tab
				tabbedPane.setEnabledAt(4, false); // Payment tab
				tabbedPane.setSelectedIndex(3); // Basket tab
			}
		});

		JPanel panel_Receipt = new JPanel();
		tabbedPane.addTab("Receipt", null, panel_Receipt, null);
		panel_Receipt.setLayout(null);
		
		JLabel lblReceipt = new JLabel("Receipt:");
		lblReceipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReceipt.setBounds(420, 41, 94, 32);
		panel_Receipt.add(lblReceipt);
		
		JLabel lblTotalAmountlbl = new JLabel("Total Amount:");
		lblTotalAmountlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAmountlbl.setBounds(351, 114, 105, 25);
		panel_Receipt.add(lblTotalAmountlbl);
		
		lblTotalAmount = new JLabel("");
		lblTotalAmount.setBackground(new Color(255, 255, 255));
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAmount.setBounds(467, 114, 119, 25);
		panel_Receipt.add(lblTotalAmount);
		
		JLabel lblDatelbl = new JLabel("Date:");
		lblDatelbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatelbl.setBounds(351, 160, 46, 25);
		panel_Receipt.add(lblDatelbl);
		
		lblDate = new JLabel("");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(400, 160, 186, 25);
		panel_Receipt.add(lblDate);
		
		JLabel lblAddresslbl = new JLabel("Address:");
		lblAddresslbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddresslbl.setBounds(351, 206, 70, 25);
		panel_Receipt.add(lblAddresslbl);
		
		lblAddress = new JLabel("");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(420, 210, 288, 21);
		panel_Receipt.add(lblAddress);
		
		lblEmailOrCardlbl = new JLabel("");
		lblEmailOrCardlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmailOrCardlbl.setBounds(351, 258, 130, 25);
		panel_Receipt.add(lblEmailOrCardlbl);
		
		lblEmailOrCard = new JLabel("");
		lblEmailOrCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmailOrCard.setBounds(467, 253, 308, 30);
		panel_Receipt.add(lblEmailOrCard);
		
		JButton btnToMenu = new JButton("Back To Menu");
		btnToMenu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnToMenu.setBounds(400, 389, 119, 21);
		panel_Receipt.add(btnToMenu);
		btnToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	tabbedPane.setEnabledAt(0, true); // Menu tab
            	tabbedPane.setEnabledAt(5, false); // Receipt tab
            	tabbedPane.setSelectedIndex(0); //Menu tab
            	//Update tables to reflect changes in text file
            	selectedBarcodes.clear();
            	updateBasketTable();
            	loadAdminTable();
            	loadCustomerTable();
            }
        });

		btnAddProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get all product information and convert to strings
				String barcode = txtBarcode.getText().trim();
				String brand = txtBrand.getText().trim();
				String color = txtColor.getText().trim();
				String connectivity = ((ConnectivityType) comboBoxConnectivity.getSelectedItem()).toString().toLowerCase();
				String quantity = txtQuantity.getText().trim();
				String originalCost = txtOriginalCost.getText().trim();
				String retailPrice = txtRetailPrice.getText().trim();
				String category = ((ProductCategory) comboBoxCategory.getSelectedItem()).toString().toLowerCase();
				String deviceType = ((DeviceType) comboBoxDeviceType.getSelectedItem()).toString().toLowerCase();
				String additionalInfo = txtAdditionalInfo.getText().trim().toUpperCase();

				Admin admin = new Admin();
				// Validate the user inputs
				String errorMsg = admin.validateData(barcode, brand, color, quantity, originalCost, retailPrice,
						category, additionalInfo);
				if (errorMsg.isEmpty()) {
					try {
						// Add product to Stock.txt
						String resultMsg = admin.addProduct(barcode, brand, color, connectivity, quantity, originalCost,
								retailPrice, category, deviceType, additionalInfo);
						clearTextFields();
						lblErrors.setText("<html>" + resultMsg + "</html>");
						loadAdminTable();
					} catch (NumberFormatException ex) {
						lblErrors.setText("Invalid numeric input.");
					}
				} else {
					lblErrors.setText("<html>" + errorMsg + "</html>");
				}

			}
		});

		loadUsernames();
		loadAdminTable();
		loadCustomerTable();
		tabbedPane.setEnabledAt(1, false); // Admin tab
		tabbedPane.setEnabledAt(2, false); // Customer tab
		tabbedPane.setEnabledAt(3, false); // Basket tab
		tabbedPane.setEnabledAt(4, false); // Payment tab
		tabbedPane.setEnabledAt(5, false); // Receipt tab
	}

	private void loadUsernames() {
		// Read UserAccounts.txt and load the usernames
		UserAccountsReader reader = new UserAccountsReader();
		try {
			List<String> userAccounts = reader.readUserAccounts();
			String[][] data = new String[userAccounts.size()][1];
			for (int i = 0; i < userAccounts.size(); i++) {
				user = reader.parseUser(userAccounts.get(i));
				if (user != null) {
					data[i][0] = user.getUsername();
				}
			}
			// Add usernames to table
			String[] columnNames = { "Username" };
			userTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
			
			// Depending on the username clicked, go to the admin or customer tab
			userTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						int selectedRow = userTable.getSelectedRow();
						if (selectedRow != -1) {
							String username = (String) userTable.getValueAt(selectedRow, 0);
							if (isAdmin(username)) {
								tabbedPane.setEnabledAt(0, false); // Menu tab
								tabbedPane.setEnabledAt(1, true); // Admin tab
								tabbedPane.setSelectedIndex(1); // Admin tab
							} else {
								tabbedPane.setEnabledAt(0, false); // Menu tab
								tabbedPane.setEnabledAt(2, true); // Customer tab
								tabbedPane.setSelectedIndex(2); // Customer tab
							}
						}
					}
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isAdmin(String username) {
		// Check is the username clicked is an admin, if not, then the user is a customer
		UserAccountsReader reader = new UserAccountsReader();
		try {
			List<String> userAccounts = reader.readUserAccounts();
			for (String account : userAccounts) {
				User user = reader.parseUser(account);
				if (user != null && user.getUsername().equals(username) && user.getRole() == Role.ADMIN) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void loadAdminTable() {
		StockReader stockReader = new StockReader();
		try {
			// Create table for admins showing all the product information
			List<String> stockData = stockReader.readStock();
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Barcode");
			model.addColumn("Brand");
			model.addColumn("Color");
			model.addColumn("Connectivity");
			model.addColumn("Quantity");
			model.addColumn("Original Cost");
			model.addColumn("Retail Price");
			model.addColumn("Category");
			model.addColumn("Device Type");
			model.addColumn("Additional Info");
			
			List<ExtendedProduct> products = new ArrayList<>();
			for (String line : stockData) {
//            	System.out.println(line);
				ExtendedProduct product = stockReader.parseProduct(line);
				if (product != null) {
					products.add(product);
				}
			}

			// Sort the list of products by retail price
			Collections.sort(products, Comparator.comparingDouble(ExtendedProduct::getRetailPrice));
			
			// Fill table with all the products
			for (ExtendedProduct product : products) {
				model.addRow(new Object[] { product.getBarcode(), product.getBrand(), product.getColor(),
						product.getConnectivity(), product.getQuantityInStock(), product.getOriginalCost(),
						product.getRetailPrice(), product.getCategory(), product.getDeviceType(),
						product.getAdditionalInfo() });
			}

			adminTable.setModel(model);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadCustomerTable() {
		StockReader stockReader = new StockReader();
		try {
			// Create table for customer showing all product info minus the original cost
			List<String> stockData = stockReader.readStock();
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Barcode");
			model.addColumn("Brand");
			model.addColumn("Color");
			model.addColumn("Connectivity");
			model.addColumn("Quantity");
			model.addColumn("Retail Price");
			model.addColumn("Category");
			model.addColumn("Device Type");
			model.addColumn("Additional Info");

			List<ExtendedProduct> products = new ArrayList<>();
			for (String line : stockData) {
//            	System.out.println(line);
				ExtendedProduct product = stockReader.parseProduct(line);
				if (product != null) {
					products.add(product);
				}
			}

			// Sort the list of products by retail price
			Collections.sort(products, Comparator.comparingDouble(ExtendedProduct::getRetailPrice));
			// Fill table with all the products
			for (ExtendedProduct product : products) {
				model.addRow(new Object[] { product.getBarcode(), product.getBrand(), product.getColor(),
						product.getConnectivity(), product.getQuantityInStock(), product.getRetailPrice(),
						product.getCategory(), product.getDeviceType(), product.getAdditionalInfo() });
			}

			customerTable.setModel(model);
			addToBasket();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addToBasket() {
		// If a row is selected on the customer table, then it gets added to the basket 
		customerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = customerTable.getSelectedRow();
					if (selectedRow != -1) {
						int barcode = (int) customerTable.getValueAt(selectedRow, 0);
						selectedBarcodes.add(barcode);
						DefaultTableModel model = (DefaultTableModel) basketTable.getModel();
						if (model.getColumnCount() == 0) {
	                        model.addColumn("Barcode");
	                        model.addColumn("Brand");
	                        model.addColumn("Color");
	                        model.addColumn("Connectivity");
	                        model.addColumn("Retail Price");
	                        model.addColumn("Category");
	                        model.addColumn("Device Type");
	                        model.addColumn("Additional Info");
	                        model.addColumn("Quantity To Buy");
	                    }
						Basket basket = new Basket((DefaultTableModel) basketTable.getModel());
	                    basket.loadBasketTable(selectedBarcodes);
					}
				}
			}
		});
	}
	
	private void updateBasketTable() {
		// Reload the basket
	    DefaultTableModel model = (DefaultTableModel) basketTable.getModel();
	    model.setRowCount(0); // Clear the existing rows
	    Basket basket = new Basket(model);
	    basket.loadBasketTable(selectedBarcodes);
	}

	private void clearTextFields() {
		txtBarcode.setText("");
		txtBrand.setText("");
		txtColor.setText("");
		txtQuantity.setText("");
		txtOriginalCost.setText("");
		txtRetailPrice.setText("");
		txtAdditionalInfo.setText("");
	}

	private void filterTableByBarcode() {
		DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		customerTable.setRowSorter(sorter);
		// Check the input barcode against the ones in the table
		String text = txtSearchBarcode.getText().trim();
		if (text.length() == 0) {
			sorter.setRowFilter(null);
		} else {
			sorter.setRowFilter(RowFilter.regexFilter(text, 0));
		}
	}

	private void filterTableByMouseButtons() {
		DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		customerTable.setRowSorter(sorter);
		// Check the input against the table
		String text = txtMouseButtons.getText().trim();
		try {
			Integer.parseInt(text); // Makes sure the user enters an integer
			if (text.length() == 0) {
				sorter.setRowFilter(null);
			} else {
				sorter.setRowFilter(RowFilter.regexFilter(text, 8));
			}
		} catch (NumberFormatException e) {
			sorter.setRowFilter(null);
		}
	}
	
	private void loadReceipt(String emailOrCard) {
		Basket basket = new Basket((DefaultTableModel) basketTable.getModel());
		double amount = basket.getTotalCost(); // Find the total amount in the basket
		basket.updateStock(selectedBarcodes);
		//Get the address of the particular user
		Address fullAddress = new Address(user.getHouseNumber(), user.getPostcode(), user.getCity());
		Receipt receipt;
		// Depending on if the user paid with credit card or paypal, go to different classes
		if (emailOrCard.equals("PayPal")) {
			PayWithPayPal payWithPayPal = new PayWithPayPal();
			receipt = payWithPayPal.processPayment(amount, fullAddress);
		} else {
			PayWithCreditCard payWithCreditCard = new PayWithCreditCard();
			receipt = payWithCreditCard.processPayment(amount, fullAddress);
		}
		//Update labels in order for the user to see the receipt information
		lblTotalAmount.setText("£"+String.valueOf(receipt.getAmount()));
		lblAddress.setText(String.valueOf(receipt.getAddress()));
		lblDate.setText(String.valueOf(receipt.getDate()));
		if (String.valueOf(receipt.getPaymentMethod()).equals("PayPal")) {
			lblEmailOrCardlbl.setText("Email: ");
			lblEmailOrCard.setText(txtEmail.getText().trim());
		} else {
			lblEmailOrCardlbl.setText("Card Number: ");
			lblEmailOrCard.setText(txtCardNumber.getText().trim());
		}
	}
	
}
