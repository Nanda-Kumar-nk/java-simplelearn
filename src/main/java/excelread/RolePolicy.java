package excelread;

import java.util.List;

public class RolePolicy {

   private List<String> resources;
   private List<String> actions;
   private String effect;

   public List<String> getResources() {
      return resources;
   }

   public void setResources(List<String> resources) {
      this.resources = resources;
   }

   public List<String> getActions() {
      return actions;
   }

   public void setActions(List<String> actions) {
      this.actions = actions;
   }

   public String getEffect() {
      return effect;
   }

   public void setEffect(String effect) {
      this.effect = effect;
   }
}
