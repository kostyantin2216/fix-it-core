/**
 * 
 */
package com.fixit.core.data.shopify;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/24 23:42:21 GMT+3
 * 
 * Shopify customer json example:
 * 
 * 	{	
 *		"id": 1234567,
 *		"email": "john@test.com",
 *		"accepts_marketing": false,
 *		"created_at": null,
 *		"updated_at": null,
 *		"first_name": "John",
 *		"last_name": "Smith",
 *		"orders_count": 0,
 *		"state": "disabled",
 *		"total_spent": "0.00",
 *		"last_order_id": null,
 *		"note": null,
 *		"verified_email": true,
 *		"multipass_identifier": null,
 *		"tax_exempt": false,
 *		"phone": null,
 *		"tags": "",
 *		"last_order_name": null,
 *		"default_address": {
 *			"id": 1234567,
 *			"first_name": null,
 *			"last_name": null,
 *			"company": null,
 *			"address1": "123 Elm St.",
 *			"address2": null,
 *			"city": "Ottawa",
 *			"province": "Ontario",
 *			"country": "Canada",
 *			"zip": "K2H7A8",
 *			"phone": "123-123-1234",
 *			"name": "",
 *			"province_code": "ON",
 *			"country_code": "CA",
 *			"country_name": "Canada",
 *			"default": false
 *		}
 *	}
 */
public class ShopifyCustomer {
	
	private long id;
	private String email;
	private String first_name;
	private String last_name;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ "]";
	}

}
