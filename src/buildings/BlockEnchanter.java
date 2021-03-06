package colonies.src.buildings;

import colonies.src.ClientProxy;
import colonies.src.ColoniesMain;
import colonies.src.Utility;
import net.minecraft.client.Minecraft;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityItem;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockEnchanter extends BlockColoniesChest {
	
	public BlockEnchanter(int id) {
		super(id);
		tileEntity = new TileEntityEnchanterChest();
		setBlockName("Enchanter Chest");
		setCreativeTab(ColoniesMain.coloniesTab);
	}


	@Override
	public String getTextureFile() {
		return ClientProxy.ENCHANTERCHEST_PNG;
	}
	
    @Override
    public TileEntity createNewTileEntity(World theWorld){
    	tileEntity = new TileEntityEnchanterChest();
        return tileEntity;
     }

    @Override
    public boolean addBlockToTown(TileEntityColoniesChest _teEnchanter){
    	if(TileEntityTownHall.playerTown != null){
    		TileEntityTownHall.playerTown.employersList.offer(_teEnchanter);
    		Utility.chatMessage("New jobs available in " + TileEntityTownHall.playerTown.townName);
    		return true;
    	}
    	return false;
    }

}
