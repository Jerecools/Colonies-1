package colonies.src.citizens;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IMerchant;
import net.minecraft.src.INpc;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MerchantRecipe;
import net.minecraft.src.MerchantRecipeList;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import paulscode.sound.Vector3D;
import colonies.src.ColoniesMain;
import colonies.src.Utility;
import colonies.src.buildings.TileEntityColoniesChest;
import colonies.vector67.src.EntityAIMine;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class EntityEnchanter extends EntityCitizen implements INpc, IMerchant


{
	
	public InventoryCitizen inventory = new InventoryCitizen(this);
	private Vector3D closestEnchanterChest;
	private static ItemStack defaultHeldItem;
	private long lastSearch;
	private int randomTickDivider;
	public boolean isTrading;
	
	static {
		defaultHeldItem = null;
	}
	
	public EntityEnchanter(World world) { 
		super(world);
		this.randomTickDivider = 0;
		this.isTrading = false;
		this.texture = ColoniesMain.skinEnchanter;
	    
	    // add this type of employment to the jobTypes if necessary
	    boolean alreadyInList = false;
	    for(EntityCitizen job : jobTypes){
	    	if(job instanceof EntityEnchanter){
	    		alreadyInList = true;
	    		break;
	    	}
	    }
	    if(!alreadyInList) jobTypes.add(this);

	}
	
	public String getTexture() {
		if (this.isInWater()) {
			return ColoniesMain.skinMinerSwimming;
		}
		return ColoniesMain.skinEnchanter;
	}

	public String getJobTitle(){
		return "Enchanter";
	}
	
	protected String getLivingSound() {
		if (citizenGreetings){
			if (Utility.getLootCategory()==3) {
				return "colonies.m-hello";
			}
		}
		return "";
	}

	// Mob Loot for Enchanter
	protected int getDropItemId() {
		int lootID=1;
		switch(Utility.getLootCategory()) {
			case 1: // Common
				switch(Utility.getLootCategory(3)) {
					case 1: return Item.appleRed.shiftedIndex;
					case 2: return Item.book.shiftedIndex;
					default:return Item.paper.shiftedIndex;
				}
			case 2: // Uncommon
				return Item.ingotGold.shiftedIndex;
			case 3: // Rare
				return ColoniesMain.ancientTome.shiftedIndex;
			default: // Legendary
				return Item.emerald.shiftedIndex;
		}
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
		int enchanterBlockID = ColoniesMain.enchanterChestID;
		if (ticksExisted - lastSearch >= 40) {
			lastSearch = ticksExisted;
			/*PathNavigator nav; // = pathToBlock(enchanterBlockID);
			if (nav == null) return;
			if (nav.getLength() < 1.5) {
				if (nav.hasLocation()) {
					if (!hasPickaxe) {
						getPickaxeFromChest(nav.getEndX(), nav.getEndY(), nav.getEndZ());
					}
				}
			} else {
				navigateToBlock(nav);
			}
			*/
		}
	}

	@Override
	public void setCustomer(EntityPlayer var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntityPlayer getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantRecipeList getRecipes(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setRecipes(MerchantRecipeList var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useRecipe(MerchantRecipe var1) {
		// TODO Auto-generated method stub
		
	}


	
	//Enchanter Interraction Code
	


}
