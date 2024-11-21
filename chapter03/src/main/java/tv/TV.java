package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power; 
	
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		if(on==true) this.power = true;
		else this.power = false;
	}
	public void channel(int channel) {
		if(1<=channel && channel<=255) this.channel = channel;
		else if(channel<1) this.channel = 255;
		else this.channel = 1;
	}
	public void channel(boolean up) {
		if(up==true) this.channel++;
		else this.channel--;
		if(channel>255) this.channel=1;
		if(channel<1) this.channel=255;
	}
	public void volume(int volume) {
		if(0<=volume && volume<=100) this.volume = volume;
		else this.volume = 0;
	}
	public void volume(boolean up) {
		if(up==true) this.volume++;
		else this.volume--;
		if(volume>100) this.volume=0;
		if(volume<0) this.volume = 100;
	}

	public void status() {
		System.out.println("TV[channel= "+channel+
				", volume= "+volume+", power= "
				+ (power?"on":"off")+"]");
	}
}
