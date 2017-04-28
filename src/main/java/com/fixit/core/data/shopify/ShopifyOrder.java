/**
 * 
 */
package com.fixit.core.data.shopify;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/24 23:48:47 GMT+3
 * 
 * Shopify order json example
 * 
 *{
 *	"id": 123456,
 *	"email": "jon@doe.ca",
 *	"closed_at": null,
 *	"created_at": "2017-04-23T15:59:00-04:00",
 *	"updated_at": "2017-04-23T15:59:00-04:00",
 *	"number": 234,
 *	"note": null,
 *	"token": "123456abcd",
 *	"gateway": null,
 *	"test": true,
 *	"total_price": "254.98",
 *	"subtotal_price": "244.98",
 *	"total_weight": 0,
 *	"total_tax": "0.00",
 *	"taxes_included": false,
 *	"currency": "USD",
 *	"financial_status": "voided",
 *	"confirmed": false,
 *	"total_discounts": "5.00",
 *	"total_line_items_price": "249.98",
 *	"cart_token": null,
 *	"buyer_accepts_marketing": true,
 *	"name": "#9999",
 *	"referring_site": null,
 *	"landing_site": null,
 *	"cancelled_at": "2017-04-23T15:59:00-04:00",
 *	"cancel_reason": "customer",
 *	"total_price_usd": null,
 *	"checkout_token": null,
 *	"reference": null,
 *	"user_id": null,
 *	"location_id": null,
 *	"source_identifier": null,
 *	"source_url": null,
 *	"processed_at": null,
 *	"device_id": null,
 *	"phone": null,
 *	"browser_ip": null,
 *	"landing_site_ref": null,
 *	"order_number": 1234,
 *	"discount_codes": [],
 *	"note_attributes": [],
 *	"payment_gateway_names": ["visa",
 *	"bogus"],
 *	"processing_method": "",
 *	"checkout_id": null,
 *	"source_name": "web",
 *	"fulfillment_status": "pending",
 *	"tax_lines": [],
 *	"tags": "",
 *	"contact_email": "jon@doe.ca",
 *	"order_status_url": null,
 *	"line_items": [{
 *		"id": 56789,
 *		"variant_id": null,
 *		"title": "Aviator sunglasses",
 *		"quantity": 1,
 *		"price": "89.99",
 *		"grams": 100,
 *		"sku": "SKU2006-001",
 *		"variant_title": null,
 *		"vendor": null,
 *		"fulfillment_service": "manual",
 *		"product_id": 327475578523353102,
 *		"requires_shipping": true,
 *		"taxable": true,
 *		"gift_card": false,
 *		"name": "Aviator sunglasses",
 *		"variant_inventory_management": null,
 *		"properties": [],
 *		"product_exists": true,
 *		"fulfillable_quantity": 1,
 *		"total_discount": "0.00",
 *		"fulfillment_status": null,
 *		"tax_lines": []
 *	},
 *	{
 *		"id": 98765,
 *		"variant_id": null,
 *		"title": "Mid-century lounger",
 *		"quantity": 1,
 *		"price": "159.99",
 *		"grams": 10000,
 *		"sku": "SKU2006-020",
 *		"variant_title": null,
 *		"vendor": null,
 *		"fulfillment_service": "manual",
 *		"product_id": 327475578523353102,
 *		"requires_shipping": true,
 *		"taxable": true,
 *		"gift_card": false,
 *		"name": "Mid-century lounger",
 *		"variant_inventory_management": null,
 *		"properties": [],
 *		"product_exists": true,
 *		"fulfillable_quantity": 1,
 *		"total_discount": "5.00",
 *		"fulfillment_status": null,
 *		"tax_lines": []
 *	}],
 *	"shipping_lines": [{
 *		"id": 1234567,
 *		"title": "Generic Shipping",
 *		"price": "10.00",
 *		"code": null,
 *		"source": "shopify",
 *		"phone": null,
 *		"requested_fulfillment_service_id": null,
 *		"delivery_category": null,
 *		"carrier_identifier": null,
 *		"tax_lines": []
 *	}],
 *	"billing_address": {
 *		"first_name": "Bob",
 *		"address1": "123 Billing Street",
 *		"phone": "555-555-BILL",
 *		"city": "Billtown",
 *		"zip": "K2P0B0",
 *		"province": "Kentucky",
 *		"country": "United States",
 *		"last_name": "Biller",
 *		"address2": null,
 *		"company": "My Company",
 *		"latitude": null,
 *		"longitude": null,
 *		"name": "Bob Biller",
 *		"country_code": "US",
 *		"province_code": "KY"
 *	},
 *	"shipping_address": {
 *		"first_name": "Steve",
 *		"address1": "123 Shipping Street",
 *		"phone": "555-555-SHIP",
 *		"city": "Shippington",
 *		"zip": "K2P0S0",
 *		"province": "Kentucky",
 *		"country": "United States",
 *		"last_name": "Shipper",
 *		"address2": null,
 *		"company": "Shipping Company",
 *		"latitude": null,
 *		"longitude": null,
 *		"name": "Steve Shipper",
 *		"country_code": "US",
 *		"province_code": "KY"
 *	},
 *	"fulfillments": [],
 *	"refunds": [],
 *	"customer": {@link ShopifyCustomer}	
 *}
 * 
 */
public class ShopifyOrder {

	private int id;
	private ShopifyCustomer customer;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public ShopifyCustomer getCustomer() {
		return customer;
	}
	
	public void setCustomer(ShopifyCustomer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + "]";
	}
	
}
