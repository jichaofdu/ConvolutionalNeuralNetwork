package convolutionalNeuralNetwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SubsampleKernel {
	private double beta;
	private double bias;
	private int tag;
	private double change;
	
	public SubsampleKernel(double beta,double bias,int tag){
		this.beta = beta;
		this.bias = bias;
		this.tag = tag;
		this.change = 0;
	}
	
	public double getBeta(){
		return beta;
	}
	
	public double getBias(){
		return bias;
	}
	
	public void setBeta(double newBeta){
		this.beta = newBeta;
	}
	
	public void settBias(double newBias){
		this.bias = newBias;
	}
	
	public int getTag(){
		return this.tag;
	}
	
	public double getChange(){
		return change;
	}
	
	public void setChange(double newChange){
		this.change = newChange;
	}
	
	public void writeToDiskSK(String path) throws FileNotFoundException, IOException{
		String fileName = "SK" + this.tag;
		fileName = path + fileName + ".obj";
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(this);
		out.close();
	}
	
	public void readFromDiskHO(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
		String fileName = "SK" + this.tag;
		fileName = path + fileName + ".obj";
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		SubsampleKernel newRead = (SubsampleKernel)in.readObject();
		this.beta = newRead.getBeta();
		this.bias = newRead.getBias();
		this.tag = newRead.getTag();
		this.change = newRead.getChange();
		in.close();
	}
}