package com.gizwits.opensource.appkit.ControlModule;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.gizwits.gizwifisdk.api.GizWifiDevice;
import com.gizwits.opensource.appkit.CommonModule.GosBaseActivity;
import com.gizwits.opensource.appkit.R;
import com.gizwits.opensource.appkit.SampleFragmentPagerAdapter;

public class GosDeviceControlActivity extends GosBaseActivity {

	/** The tv MAC */
	private TextView tvMAC;

	/** The GizWifiDevice device */
	private GizWifiDevice device;

	/** The ActionBar actionBar */
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gos_device_control);
		initDevice();
		setActionBar(true, true, device.getProductName());
		ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
		viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),GosDeviceControlActivity.this));
		TabLayout tabLayout= (TabLayout) findViewById(R.id.sliding_tabs);
		tabLayout.setupWithViewPager(viewPager);
		//initView();
	}
	/*
	private void initView() {
		tvMAC = (TextView) findViewById(R.id.tvMAC);
		if (null != device) {

			tvMAC.setText(device.getMacAddress().toString());

		}
	}
	*/
	private void initDevice() {
		Intent intent = getIntent();
		device = (GizWifiDevice) intent.getParcelableExtra("GizWifiDevice");
		Log.i("Apptest", device.getDid());
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}